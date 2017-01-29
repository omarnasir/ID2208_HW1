<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:ns="http://www.GPA.com" xmlns:tran="http://www.employmentservicecompany.org">
  <xsl:template match="/">
    <xsl:element name="ns:GPA">
      <xsl:for-each select="/Transcript/tran:Courses/tran:Course">
        <xsl:element name="ns:CoffeeName">
          <xsl:value-of select="//tran:Credits"/>
        </xsl:element>
      </xsl:for-each>
      <xsl:element name="ns:TotalGPA">
        <xsl:value-of select="sum(//tran:Credits)"/>
      </xsl:element>
    </xsl:element>
  </xsl:template>
</xsl:stylesheet>
