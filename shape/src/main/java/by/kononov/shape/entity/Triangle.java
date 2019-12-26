package by.kononov.shape.entity;

import java.util.ArrayList;
import java.util.List;

import by.kononov.shape.listener.TriangleListener;

public class Triangle{
	private List<TriangleListener> listeners = new ArrayList<>();
	private long triangleId;
	private Dot dotA;
	private Dot dotB;
	private Dot dotC;

	public Triangle(long triangleId, Dot dotA, Dot dotB, Dot dotC) {
		this.triangleId = triangleId;
		this.dotA = dotA;
		this.dotB = dotB;
		this.dotC = dotC;
	}

	public void notifyObserver() {
		for (TriangleListener element : listeners) {
			element.update(this);
		}
	}

	public void addListener(TriangleListener listener) {
		listeners.add(listener);
	}

	public void removeListener(TriangleListener listener) {
		listeners.remove(listener);
	}

	public long getId() {
		return triangleId;
	}

	public void setId(long newId) {
		this.triangleId = newId;
		notifyObserver();
	}

	public Dot getDotA() {
		return dotA;
	}

	public void setDotA(Dot dotA) {
		this.dotA = dotA;
		notifyObserver();
	}

	public Dot getDotB() {
		return dotB;
	}

	public void setDotB(Dot dotB) {
		this.dotB = dotB;
		notifyObserver();
	}

	public Dot getDotC() {
		return dotC;
	}

	public void setDotC(Dot dotC) {
		this.dotC = dotC;
		notifyObserver();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 1;
		hash = prime * hash + (int) triangleId;
		hash = prime * hash + (dotA == null ? 0 : dotA.hashCode());
		hash = prime * hash + (dotB == null ? 0 : dotB.hashCode());
		hash = prime * hash + (dotC == null ? 0 : dotC.hashCode());
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
		Triangle triangle = (Triangle) obj;
		if (triangleId != triangle.triangleId) {
			return false;
		}
		if (dotA == null) {
			if (triangle.dotA == null) {
				return false;
			}
		} else {
			if (!dotA.equals(triangle.dotA)) {
				return false;
			}
		}
		if (dotB == null) {
			if (triangle.dotB == null) {
				return false;
			}
		} else {
			if (!dotB.equals(triangle.dotB)) {
				return false;
			}
		}
		if (dotC == null) {
			if (triangle.dotC == null) {
				return false;
			}
		} else {
			if (!dotC.equals(triangle.dotC)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s, id=%s, %s,%s,%s", getClass().getSimpleName(), triangleId, dotA, dotB, dotC);
	}
}