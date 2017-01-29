<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:ns="http://www.GPA.com" xmlns:tran="http://www.employmentservicecompany.org">
    <xsl:template match="/">
        <xsl:element name="ns:GPA">

            <xsl:element name="ns:StudentName">
                <xsl:value-of select="/Transcript/tran:Name"/>
            </xsl:element>

            <xsl:element name="ns:StudentID">
                <xsl:value-of select="/Transcript/tran:StudentID"/>
            </xsl:element>

            <xsl:element name="ns:University">
                <xsl:value-of select="/Transcript/tran:University"/>
            </xsl:element>

            <xsl:element name="ns:Degree">
                <xsl:value-of select="/Transcript/tran:Degree"/>
            </xsl:element>

            <xsl:element name="ns:Startingyear">
                <xsl:value-of select="/Transcript/tran:Startingyear"/>
            </xsl:element>


            <xsl:element name="ns:Endingyear">
                <xsl:value-of select="/Transcript/tran:Endingyear"/>
            </xsl:element>

            <xsl:element name="ns:TotalGPA">
                <xsl:value-of select="sum(//tran:Credits)"/>
            </xsl:element>

        </xsl:element>
    </xsl:template>
</xsl:stylesheet>