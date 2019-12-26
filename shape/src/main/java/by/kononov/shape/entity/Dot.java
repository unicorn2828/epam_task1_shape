package by.kononov.shape.entity;

public class Dot{
	private String dotName;
	private double coordinateX;
	private double coordinateY;

	public Dot(String dotName, double coordinateX, double coordinateY) {
		this.dotName = dotName;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	public String getName() {
		return dotName;
	}

	public void setName(String name) {
		this.dotName = name;
	}

	public double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 1;
		hash = prime * hash + (dotName == null ? 0 : dotName.hashCode());
		long temp = Double.doubleToLongBits(coordinateX);
		hash = prime * hash + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(coordinateY);
		hash = prime * hash + (int) (temp ^ (temp >>> 32));
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Dot dot = (Dot) obj;
		if (Double.doubleToLongBits(coordinateX) != Double.doubleToLongBits(dot.coordinateX)
				|| Double.doubleToLongBits(coordinateY) != Double.doubleToLongBits(dot.coordinateY)) {
			return false;
		}
		if (dotName == null) {
			if (dot.dotName != null) {
				return false;
			}
		} else {
			if (!dotName.equals(dot.dotName)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("[%s, name=%s, %s, %s]", getClass().getSimpleName(), dotName, coordinateX, coordinateY);
	}
}