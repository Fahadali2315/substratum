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

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import projekt.substratum.adapters.fragments.settings.Repository;
import projekt.substratum.common.References;

public enum ReadRepositoriesFile {
    ;

    public static List<Repository> main(final String file) {

        try {
            final File fXmlFile = new File(file);

            final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            final Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            final NodeList nList = doc.getElementsByTagName("repo");

            final List<Repository> list = new ArrayList<>();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                final Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    final Element eElement = (Element) nNode;
                    final Repository current = new Repository(eElement.getAttribute("name"));
                    Log.d(References.SUBSTRATUM_VALIDATOR,
                            "Pulling live resources from '" + current.getPackageName() + "'!");
                    try {
                        final String bools = eElement.getElementsByTagName("bools")
                                .item(0).getTextContent();
                        current.setBools(bools);
                    } catch (final Exception e) {
                        // Suppress warning
                    }
                    try {
                        final String colors = eElement.getElementsByTagName("colors")
                                .item(0).getTextContent();
                        current.setColors(colors);
                    } catch (final Exception e) {
                        // Suppress warning
                    }
                    try {
                        final String dimens = eElement.getElementsByTagName("dimens")
                                .item(0).getTextContent();
                        current.setDimens(dimens);
                    } catch (final Exception e) {
                        // Suppress warning
                    }
                    try {
                        final String styles = eElement.getElementsByTagName("styles")
                                .item(0).getTextContent();
                        current.setStyles(styles);
                    } catch (final Exception e) {
                        // Suppress warning
                    }
                    list.add(current);
                }
            }
            return list;
        } catch (final Exception e) {
            e.printStackTrace();
            final List<Repository> emptyList = new ArrayList<>();
            return emptyList;
        }
    }
}