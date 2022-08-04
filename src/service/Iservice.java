/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;

/**
 *
 * @author wiemhjiri
 */
public interface Iservice <T>{
    
    void add(T t);
    void delete(T t);
    T readById(int id);
    ArrayList<T>readAll();
    void update(T t);
    
}
