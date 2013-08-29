<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:demo="urn:demo"
    exclude-result-prefixes="xs"
    version="2.0">
    <xsl:template match="demo:my-message">
        <newdemo:transformed-message xmlns:newdemo="urn:new-demo">
            <newdemo:txt>
                <xsl:apply-templates select="demo:value"/>
            </newdemo:txt>
        </newdemo:transformed-message>

    </xsl:template>
</xsl:stylesheet>
