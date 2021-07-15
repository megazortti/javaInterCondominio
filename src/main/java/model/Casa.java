package model;

public class Casa {
	
	private int numDaCasa;
        private String proprietario;

	public int getNumDaCasa() {
		return numDaCasa;
	}

	public void setNumDaCasa(int numDaCasa) {
		this.numDaCasa = numDaCasa;
	}

    /**
     * @return the proprietario
     */
    public String getProprietario() {
        return proprietario;
    }

    /**
     * @param proprietario the proprietario to set
     */
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
	
}
