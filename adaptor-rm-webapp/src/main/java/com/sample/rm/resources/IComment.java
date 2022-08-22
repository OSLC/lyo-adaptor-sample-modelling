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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

import org.eclipse.lyo.oslc4j.core.annotation.OslcAllowedValue;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcMemberProperty;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRdfCollectionType;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

import com.sample.rm.resources.Oslc_rmDomainConstants;
import com.sample.rm.resources.FoafDomainConstants;
import com.sample.rm.resources.DctermsDomainConstants;
import com.sample.rm.resources.Oslc_rmDomainConstants;

import com.sample.rm.resources.IPerson;
// Start of user code imports
// End of user code

@OslcNamespace(Oslc_rmDomainConstants.COMMENT_NAMESPACE)
@OslcName(Oslc_rmDomainConstants.COMMENT_LOCALNAME)
@OslcResourceShape(title = "Comment Shape", describes = Oslc_rmDomainConstants.COMMENT_TYPE)
public interface IComment
{


    @OslcName("description")
    @OslcPropertyDefinition(DctermsDomainConstants.DUBLIN_CORE_NAMSPACE + "description")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.String)
    @OslcReadOnly(false)
    public String getDescription();

    @OslcName("date")
    @OslcPropertyDefinition(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "date")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.DateTime)
    @OslcReadOnly(false)
    public Date getDate();

    @OslcName("author")
    @OslcPropertyDefinition(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE + "author")
    @OslcOccurs(Occurs.ExactlyOne)
    @OslcValueType(ValueType.Resource)
    @OslcRange({FoafDomainConstants.PERSON_TYPE})
    @OslcReadOnly(false)
    public Link getAuthor();


    public void setDescription(final String description );
    public void setDate(final Date date );
    public void setAuthor(final Link author );
}

