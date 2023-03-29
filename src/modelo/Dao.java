package modelo;


public interface Dao<U> {
	
	public Integer insert(U u);
	public Boolean update(U u);
	public Boolean remove(U u);
}
