/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Materia;
import Entidades.Nota;
import com.alex.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class NotasMaterias {
     
    ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConecction();
    
    
    
     public void AddNota(Nota nt){
    try {
            CallableStatement cb = conexion.prepareCall("{call SP_I_Notas(?,?,?)}");
            cb.setString("Pnota", nt.getNota());
            cb.setInt("PidMateria", nt.getIdMateria());
            cb.setInt("PidEstudiante", nt.getIdEstudiante());
         
            cb.execute();
            
         //   JOptionPane.showMessageDialog(null, "Notas agregadas",);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString(),"Mensje sistems",1);
            
        }}
}
