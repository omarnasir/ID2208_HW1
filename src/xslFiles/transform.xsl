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

            <xsl:variable name="ns:tmpTotal">
                <xsl:for-each select ="Transcript/tran:Courses/tran:Course">
                    <credit>
                        <xsl:value-of select="tran:Credits"/>
                    </credit>
                    <item>
                        <xsl:value-of select="tran:Credits * tran:Grade"/>
                    </item>
                </xsl:for-each>
            </xsl:variable>

            <xsl:variable name="ns:tempval">
                <totalmarks>
                    <xsl:variable name="ns:myTotal" select="nodeset($ns:tmpTotal)"/>
                    <xsl:value-of select="sum($ns:myTotal/item)" />
                </totalmarks>

                <totalcredits>
                    <xsl:variable name="ns:myTotal" select="nodeset($ns:tmpTotal)"/>
                    <xsl:value-of select="sum($ns:myTotal/credit)" />
                </totalcredits>
            </xsl:variable>

            <xsl:element name="ns:TotalGPA">
                <xsl:variable name="ns:result" select="nodeset($ns:tempval)"/>
                <xsl:value-of select="round($ns:result/totalmarks div $ns:result/totalcredits)" />
            </xsl:element>

        </xsl:element>
    </xsl:template>
</xsl:stylesheet>