package by.kononov.shape.sort;

import static by.kononov.shape.data.impl.TriangleDataImpl.ANGLE_A;
import static by.kononov.shape.data.impl.TriangleDataImpl.ANGLE_B;
import static by.kononov.shape.data.impl.TriangleDataImpl.ANGLE_C;
import static by.kononov.shape.data.impl.TriangleDataImpl.PERIMETER;
import static by.kononov.shape.data.impl.TriangleDataImpl.SIDE_AB;
import static by.kononov.shape.data.impl.TriangleDataImpl.SQUARE;

import java.util.Comparator;

import by.kononov.shape.entity.Triangle;

public enum TriangleComparator {
	BY_ID((o1, o2) -> Long.compare(o1.getId(), o2.getId())),
	BY_SQUARE((o1, o2) -> Double.compare(SQUARE.service(o1), SQUARE.service(o2))),
	BY_PERIMETER((o1, o2) -> Double.compare(PERIMETER.service(o1), PERIMETER.service(o2))),
	BY_ANGLE_A((o1, o2) -> Double.compare(ANGLE_A.service(o1), ANGLE_A.service(o2))),
	BY_ANGLE_B((o1, o2) -> Double.compare(ANGLE_B.service(o1), ANGLE_B.service(o2))),
	BY_ANGLE_C((o1, o2) -> Double.compare(ANGLE_C.service(o1), ANGLE_C.service(o2))),
	BY_SIDE_AB((o1, o2) -> Double.compare(SIDE_AB.service(o1), SIDE_AB.service(o2))),
	BY_DOT_A_COORDINATE_X((o1, o2) -> Double.compare(o1.getDotA().getCoordinateX(), o2.getDotA().getCoordinateX()));

	private Comparator<Triangle> comparator;

	private TriangleComparator(Comparator<Triangle> comparator) {
		this.comparator = comparator;
	}

	public Comparator<Triangle> getComparator() {
		return comparator;
	}
}
