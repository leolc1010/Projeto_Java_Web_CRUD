package ec.ftt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ec.ftt.model.Aluno;
import ec.ftt.util.DBUtil;

public class AlunoDao {

    private Connection connection;

    public AlunoDao() {
        connection = DBUtil.getConnection();
    } //UserDao

    public void addAluno(Aluno aluno) {
        
    	//https://www.devmedia.com.br/assertions-em-java/28781
    	
    	try {
    		
    		System.out.println("Here we are...");
    		
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT ftt.Aluno (Nome, RA, Curso) VALUES (?, ?, ?)");
            
            // Parameters start with 1
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getRa());
            //preparedStatement.setDate(3, (java.sql.Date)user.getDob());
            preparedStatement.setString(3, aluno.getCurso());

            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //addUser
    
    public void deleteAluno(Long id) {
    	
    	Aluno aluno = new Aluno();
    	aluno.setId(id);
    	
    	deleteAluno(aluno);
    	
    } // deleteUser long

    public void deleteAluno(Aluno aluno) {
        try {
            
        	PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM ftt.Aluno WHERE ID=?");
        	
        	/*
        	 * 
        	 * DELETE FROM `ftt`.`USER` WHERE <{where_expression}>;

        	 * 
        	 */
            
            // Parameters start with 1
            preparedStatement.setLong(1, aluno.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //deleteUser

    public void updateAluno(Aluno aluno) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE ftt.Aluno SET Nome=?, " 
                    		                          + "Ra=?, " 
                    		                          + "Curso=? " 
                                               + "WHERE ID=?");
            
            /*
             * 
             * UPDATE `ftt`.`USER`
				SET
					`ID` = <{ID: }>,
					`NAME` = <{NAME: }>,
					`EMAIL` = <{EMAIL: }>,
					`COLOR` = <{COLOR: }>
					WHERE `ID` = <{expr}>;

             * 
             */
            
            // Parameters start with 1
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getRa());
            //preparedStatement.setDate(3, (java.sql.Date)user.getDob());
            preparedStatement.setString(3, aluno.getCurso());
            
            preparedStatement.setLong(4, aluno.getId());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } //updateUser

    public List<Aluno> getAllAluno() {
        
    	List<Aluno> alunoList = new ArrayList<Aluno>();
        
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ftt.Aluno");
            while (rs.next()) {
                
            	Aluno aluno = new Aluno();
                
            	aluno.setId(rs.getLong("ID"));
                aluno.setNome(rs.getString("Nome"));
                aluno.setRa(rs.getString("Ra"));
                aluno.setCurso(rs.getString("Curso"));
                //user.setDob(rs.getDate("DOB"));

                alunoList.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunoList;
    } //getAllUser

    public Aluno getAlunoById(Long id) {
    	
    	Aluno aluno = new Aluno();
    	aluno.setId(id);
    	
    	return getAlunoById(aluno);
    	
    } // getUserById long
    
    
    	
    public Aluno getAlunoById(Aluno aluno) {

    	Aluno alunoOutput = new Aluno();
        
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * from ftt.Aluno WHERE ID=?");
            
            preparedStatement.setLong(1, aluno.getId());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	alunoOutput.setId(rs.getLong("ID"));
            	alunoOutput.setNome(rs.getString("Nome"));
            	alunoOutput.setRa(rs.getString("Ra"));
            	//userOutput.setDob(rs.getDate("DOB"));
            	alunoOutput.setCurso(rs.getString("Curso"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunoOutput;
    } //getUserById
    
    public String getDbDate() {

    	String output="";
    	
    	try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT now() NOW");
            
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	output = rs.getString("NOW");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    } //getDbDate
    
} //UserDao