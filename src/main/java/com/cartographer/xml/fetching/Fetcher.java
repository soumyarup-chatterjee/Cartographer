package com.cartographer.xml.fetching;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Fetcher {

    private <K> K fetch(Node node, String xpath, int fromIdx) {
        if (node != null && !xpath.contentEquals("")) {
            int toIdx = fromIdx != -1 ? xpath.indexOf('.', fromIdx) : -1;
            String next = (toIdx != -1) ? xpath.substring(fromIdx, toIdx) : xpath.substring(fromIdx);
            NodeList nodeList = node.getChildNodes();
            int len = nodeList.getLength();
            for (int i = 0; i < len; i++) {
                Node curr = nodeList.item(i);
                if (curr.getNodeName().contentEquals(next) && curr.getNodeType() == Node.ELEMENT_NODE)
                    return fetch(curr, (toIdx == -1 ? "" : xpath), toIdx + 1);
            }
        }
        return null;
    }

    public <K> K fetch(Node node, String xpath) {
        return this.fetch(node, xpath, 0);
    }
}
