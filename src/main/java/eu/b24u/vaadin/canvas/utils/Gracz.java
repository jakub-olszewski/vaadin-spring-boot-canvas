package eu.b24u.vaadin.canvas.utils;

public class Gracz {
	String imieGracza;

	public String pobierzImieGracza() {
		return imieGracza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(czas);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((imieGracza == null) ? 0 : imieGracza.hashCode());
		result = prime * result + punkty;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gracz other = (Gracz) obj;
		if (Double.doubleToLongBits(czas) != Double.doubleToLongBits(other.czas))
			return false;
		if (imieGracza == null) {
			if (other.imieGracza != null)
				return false;
		} else if (!imieGracza.equals(other.imieGracza))
			return false;
		if (punkty != other.punkty)
			return false;
		return true;
	}

	public void ustawImieGracza(String imieGracza) {
		this.imieGracza = imieGracza;
	}

	int punkty;
	double czas;

	/**
	 * Zamiana gracza na napis
	 */
	@Override
	public String toString() {
		return "Gracz [imieGracza=" + imieGracza + ", punkty=" + punkty + ", czas=" + czas + "]";
	}
}
