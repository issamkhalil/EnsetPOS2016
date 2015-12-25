/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.widgets;

import com.entities.Client;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author elmottaki
 */
    public class MyListModel<T> implements ListModel<T> {

        List<T> list;

        public MyListModel(List<T> list) {
            this.list = list;
        }

        @Override
        public int getSize() {
            return list.size();
        }

        @Override
        public T getElementAt(int index) {
            return list.get(index);
        }

        @Override
        public void addListDataListener(ListDataListener l) {

        }

        @Override
        public void removeListDataListener(ListDataListener l) {
        }

    }