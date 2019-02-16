# lyo-adaptor-sample-modelling

[![Build Status](https://travis-ci.org/OSLC/lyo-adaptor-sample-modelling.svg?branch=master)](https://travis-ci.org/OSLC/lyo-adaptor-sample-modelling)
[![Discourse status](https://img.shields.io/discourse/https/meta.discourse.org/status.svg)](https://forum.open-services.net/)
[![Gitter](https://img.shields.io/gitter/room/nwjs/nw.js.svg)](https://gitter.im/OSLC/chat)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FOSLC%2Flyo-adaptor-sample-modelling.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2FOSLC%2Flyo-adaptor-sample-modelling?ref=badge_shield)

This is the repository with the sources of the finished [Lyo Toolchain Modelling and Code Generation Workshop](https://wiki.eclipse.org/Lyo/ToolchainModellingAndCodeGenerationWorkshop).

The repository contains 
 * **toolchain-model** - A Lyo Designer modelling project that models 2 communicating OSLC Servers, together with their relevant domain specifications. 
 * **adaptor-rm-webapp** - an OSLC server that serves Requirement resources. You can explore the server starting with its [Service Provider Catalog on localhost:8081](http://localhost:8081/adaptor-rm/services/catalog/singleton). 
 * **adaptor-testing-webapp** - an OSLC server that serves TestScript resources, while consuming resources from the *adaptor-rm-webapp* server. You can explore the server starting with its [Service Provider Catalog on localhost:8082](http://localhost:8082/adaptor-testing/services/catalog/singleton).

![Toolchain Model](img/ToolchainDiagram.png)

![Domain Specification Model](img/SpecificationDiagram.png)



## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FOSLC%2Flyo-adaptor-sample-modelling.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2FOSLC%2Flyo-adaptor-sample-modelling?ref=badge_large)