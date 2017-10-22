/*
 * Copyright (c) 2016-2017 Projekt Substratum
 * This file is part of Substratum.
 *
 * Substratum is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Substratum is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Substratum.  If not, see <http://www.gnu.org/licenses/>.
 */

package projekt.substratum.util.readers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public enum ReadCloudShowcaseFile {
    ;

    public static Map main(final String[] argv) {

        final Map<String, String> map = new TreeMap<>();
        final Map<String, String> emptyMap = new TreeMap<>();

        try {
            final File fXmlFile = new File(argv[0]);

            final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            final Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            final NodeList nList = doc.getElementsByTagName("theme");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                final Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    final Element eElement = (Element) nNode;

                    final String addon_download_name = eElement.getAttribute("id");
                    final String addon_download_link = eElement.getElementsByTagName("link").item(0).
                            getTextContent();
                    final String addon_author = eElement.getElementsByTagName("author").item(0).
                            getTextContent();
                    String addon_image = "";
                    try {
                        // Try to see if the entry has an image override tag <image>
                        addon_image = eElement.getElementsByTagName("image")
                                .item(0).getTextContent();
                    } catch (final Exception e) {
                        // There is no image override tag
                    }

                    String addon_backgroundimage = "";
                    try {
                        // Try to see if the entry has an image override tag <backgroundimage>
                        addon_backgroundimage = eElement.getElementsByTagName("backgroundimage")
                                .item(0).getTextContent();
                    } catch (final Exception e) {
                        // There is no image override tag
                    }

                    String addon_package_name = "";
                    try {
                        // Try to see if the entry has an image override tag <backgroundimage>
                        addon_package_name = eElement.getElementsByTagName("package")
                                .item(0).getTextContent();
                    } catch (final Exception e) {
                        // There is no image override tag
                    }

                    final String addon_pricing = eElement.getElementsByTagName("pricing").item(0).
                            getTextContent();
                    final String addon_support = eElement.getElementsByTagName("support").item(0).
                            getTextContent();

                    if (addon_image.isEmpty() && addon_backgroundimage.isEmpty()) {
                        final String[] finalArray = {addon_download_name, addon_download_link,
                                addon_author, addon_pricing, addon_package_name, addon_support};
                        map.put(finalArray[0], finalArray[1]);
                        map.put(finalArray[0] + "-author", finalArray[2]);
                        map.put(finalArray[0] + "-pricing", finalArray[3]);
                        map.put(finalArray[0] + "-package-name", finalArray[4]);
                        map.put(finalArray[0] + "-support", finalArray[5]);
                    } else {
                        final String[] finalArray = {addon_download_name, addon_download_link,
                                addon_author, addon_pricing, addon_image, addon_backgroundimage,
                                addon_package_name, addon_support};
                        map.put(finalArray[0], finalArray[1]);
                        map.put(finalArray[0] + "-author", finalArray[2]);
                        map.put(finalArray[0] + "-pricing", finalArray[3]);
                        map.put(finalArray[0] + "-image-override", finalArray[4]);
                        map.put(finalArray[0] + "-feature-image", finalArray[5]);
                        map.put(finalArray[0] + "-package-name", finalArray[6]);
                        map.put(finalArray[0] + "-support", finalArray[7]);
                    }
                }
            }
            return map;
        } catch (final Exception e) {
            return emptyMap;
        }
    }
}