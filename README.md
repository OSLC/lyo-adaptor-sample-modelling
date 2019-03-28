# lyo-adaptor-sample-modelling

[![Build Status](https://travis-ci.org/OSLC/lyo-adaptor-sample-modelling.svg?branch=master)](https://travis-ci.org/OSLC/lyo-adaptor-sample-modelling)
[![Discourse status](https://img.shields.io/discourse/https/meta.discourse.org/status.svg)](https://forum.open-services.net/)
[![Gitter](https://img.shields.io/gitter/room/nwjs/nw.js.svg)](https://gitter.im/OSLC/chat)

This is the repository with the sources of the finished [Lyo Toolchain Modelling and Code Generation Workshop](https://wiki.eclipse.org/Lyo/ToolchainModellingAndCodeGenerationWorkshop).

**Note**: If you want to work with the latest version of the Lyo SDK and Lyo Designer (that is, 4.0.0-SNAPSHOT, which uses JAX-RS2.0, instead of Wink), then please refer to the [4.0.0-snapshot branch](https://github.com/OSLC/lyo-adaptor-sample-modelling/tree/4.0.0-snapshot)

The repository contains 
 * **toolchain-model** - A Lyo Designer modelling project that models 2 communicating OSLC Servers, together with their relevant domain specifications. 
 * **adaptor-rm-webapp** - an OSLC server that serves Requirement resources. You can explore the server starting with its [Service Provider Catalog on localhost:8081](http://localhost:8081/adaptor-rm/services/catalog/singleton). 
 * **adaptor-testing-webapp** - an OSLC server that serves TestScript resources, while consuming resources from the *adaptor-rm-webapp* server. You can explore the server starting with its [Service Provider Catalog on localhost:8082](http://localhost:8082/adaptor-testing/services/catalog/singleton).

![Toolchain Model](img/ToolchainDiagram.png)

![Domain Specification Model](img/SpecificationDiagram.png)

