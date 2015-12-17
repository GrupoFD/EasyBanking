/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easybanking.singleton;

import java.util.ArrayList;

/**
 *
 * @author Joselyn
 * @param <GenericObject>
 * 
 */
public interface InterfaceCRUD<GenericObject>{
   public GenericObject readClient(Object key);
   public boolean create(GenericObject c);
   public boolean delete(GenericObject c);
   public boolean update(GenericObject c );
   public GenericObject read(GenericObject c);
   public ArrayList<GenericObject> readAll();
}
