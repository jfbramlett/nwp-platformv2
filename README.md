# NWP Platform v2
This is an example of a much simplified NW Platform. Instead of everything being configurable it takes a more
opinionated approach to the platform, "routes" are fixed and are essentially:

transform protocol to EEL -> FI handler in EEL -> transform response form EEL to protocol

In the above protocol would be something like DDA 1.0, FDX 3.0, etc... - essentially there is a fixed
mapping of a given protocol to our internal format. We then have FI specific code that handles the processing
of a request using our internal format and then we translate back to the protocol.

The FI handling would be externalized in to something like an AWS lambda or simple external REST service
to allow those to be added/removed without impacting the core of the platform. Those external FI integrations
would be expected to conform to a specific spec (a compliance test case would be provided that a dev could run
to ensure they are meeting spec). The FI integrations all work with EEL so are protocol agnostic. By having the 
FI integration coded rather than configured we again simplify the effort to add a new FI letting devs or 
system integrators work in something they are comfortable with (and do so in a language agnostic way). It also
reduces the question of is the problem in my mapping or in the platform that happens when relying on configuration.

While this example would be to show multiple protocols in a single jar we could split this in to protocol
specific releases too though initially I would probably keep them all in a single codebase.