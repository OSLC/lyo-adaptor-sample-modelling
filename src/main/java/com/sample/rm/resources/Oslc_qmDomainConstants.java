// Start of user code Copyright
/*
 * Copyright (c) 2020 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Simple
 *
 * This file is generated by Lyo Designer (https://www.eclipse.org/lyo/)
 */
// End of user code

package com.sample.rm.resources;

import org.eclipse.lyo.oslc4j.core.model.OslcConstants;


// Start of user code imports
// End of user code

public interface Oslc_qmDomainConstants
{
    // Start of user code user constants
    // End of user code

    public static String QUALITY_MANAGEMENT_DOMAIN = "Quality Management";
    public static String QUALITY_MANAGEMENT_NAMSPACE = "http://open-services.net/ns/qm#"; //Vocabulary namespace for the resources and resource properties, when no explicit vocabulary (describes, or propertyDefinition) is defined 
    public static String QUALITY_MANAGEMENT_NAMSPACE_PREFIX = "oslc_qm"; //Vocabulary prefix for the resources and resource properties, when no explicit vocabulary (describes, or propertyDefinition) is defined

    public static String TESTCASE_PATH = "testCase";  //the relative path of the resource shape URL.
    public static String TESTCASE_NAMESPACE = QUALITY_MANAGEMENT_NAMSPACE; //namespace of the rdfs:class the resource describes
    public static String TESTCASE_LOCALNAME = "TestCase"; //localName of the rdfs:class the resource describes
    public static String TESTCASE_TYPE = TESTCASE_NAMESPACE + TESTCASE_LOCALNAME; //fullname of the rdfs:class the resource describes
    public static String TESTPLAN_PATH = "testPlan";  //the relative path of the resource shape URL.
    public static String TESTPLAN_NAMESPACE = QUALITY_MANAGEMENT_NAMSPACE; //namespace of the rdfs:class the resource describes
    public static String TESTPLAN_LOCALNAME = "TestPlan"; //localName of the rdfs:class the resource describes
    public static String TESTPLAN_TYPE = TESTPLAN_NAMESPACE + TESTPLAN_LOCALNAME; //fullname of the rdfs:class the resource describes
    public static String TESTSCRIPT_PATH = "testScript";  //the relative path of the resource shape URL.
    public static String TESTSCRIPT_NAMESPACE = QUALITY_MANAGEMENT_NAMSPACE; //namespace of the rdfs:class the resource describes
    public static String TESTSCRIPT_LOCALNAME = "TestScript"; //localName of the rdfs:class the resource describes
    public static String TESTSCRIPT_TYPE = TESTSCRIPT_NAMESPACE + TESTSCRIPT_LOCALNAME; //fullname of the rdfs:class the resource describes
}
