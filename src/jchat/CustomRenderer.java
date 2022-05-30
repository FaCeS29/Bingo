/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jchat;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

class CustomRenderer extends DefaultTableCellRenderer {

    int nr;
    Vector nb;

    public CustomRenderer(int nr, Vector nb) {

        this.nr = nr;
        this.nb = nb;
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String data = table.getValueAt(row, column).toString();
        int val = Integer.parseInt(data);

        if (val == this.nr) {
            c.setBackground(Color.gray);
        } else if (nb.contains(val)) {
            c.setBackground(Color.gray);
        } else {

            c.setBackground(table.getBackground());
        }

        return c;
    }
}
