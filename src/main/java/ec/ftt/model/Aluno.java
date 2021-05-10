package ec.ftt.model;

import java.util.Objects;

//JavaBean >> Serializable, Geters Seters, default contructor, [toString, equals, hash]
//POJO - Plain Old Java Objects

//https://www.devmedia.com.br/use-a-serializacao-em-java-com-seguranca/29012
//https://sites.google.com/site/sureshdevang/java-bean-v-s-pojo
//https://pt.wikipedia.org/wiki/Plain_Old_Java_Objects
//https://pt.wikipedia.org/wiki/JavaBeans


public class Aluno {

	private long id;
	private String nome,
	               ra,
	               curso;
	
	public Aluno() {
		
	}
	public Aluno(String id, String nome, String ra, String curso) {
		super();
		setId(id);
		setNome(nome);
		setRa(ra);
		setCurso(curso);
	}
	
	public Aluno(long id, String nome, String ra, String curso) {
		super();
		//setId(id);
		setNome(nome);
		setRa(ra);
		setCurso(curso);
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		
		if (id.length()==0)
			setId(0);
		else
			setId(Long.valueOf(id));
	}
	/**
	 * @return the name
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param name the name to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the email
	 */
	public String getRa() {
		return ra;
	}
	/**
	 * @param email the email to set
	 */
	public void setRa(String ra) {
		this.ra = ra;
	}
	/**
	 * @return the color
	 */
	public String getCurso() {
		return curso;
	}
	/**
	 * @param color the color to set
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", ra=" + ra + ", curso=" + curso + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(curso, ra, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Aluno)) {
			return false;
		}
		Aluno other = (Aluno) obj;
		return Objects.equals(curso, other.curso) && Objects.equals(ra, other.ra) && id == other.id
				&& Objects.equals(nome, other.nome);
	}
	
	
	
	
}
