// Start of user code "Copyright Header"
/*******************************************************************************
 Copyright (c) 2017 KTH Royal Institute of Technology.

  All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
and Eclipse Distribution License v. 1.0 which accompanies this distribution.

  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
  and the Eclipse Distribution License is available at
http://www.eclipse.org/org/documents/edl-v10.php.

  Contributors:

    Fr�d�ric Loiret     - Switch the template to Bootstrap (519699)
    Andrii Berezovskyi  - Support for UI Preview (494303)

This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

$(function () {
  function attachIframeToHyperlinkElement(iframeTitle, iframeHtml, resourceCompactStructure, uiElem) {
    uiElem.attr('data-original-title', iframeTitle);
    uiElem.attr('data-content', iframeHtml);
    uiElem.data('bs.popover').setContent();
  }
      
  var previewLinks = $("a.oslc-resource-link");
  previewLinks.popover({
    container: "body",
    content: "Loading...",
    delay: {"show": 120, "hide": 60},
    html: true,
    placement: "auto",
    trigger: "hover"
  });

  previewLinks.on("show.bs.popover", function () {
    var uiElem = $(this);
    var popoverElem = uiElem.data('bs.popover');
    getUiPreviewIframe(this.getAttribute("href"), attachIframeToHyperlinkElement, uiElem);
  })

});
