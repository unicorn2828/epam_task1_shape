package by.kononov.shape.data.impl;

import by.kononov.shape.data.TriangleData;
import by.kononov.shape.entity.Triangle;

public enum TriangleDataImpl implements TriangleData {
	PERIMETER {
		@Override
		public double service(Triangle triangle) {
			return SIDE_AB.service(triangle) + SIDE_BC.service(triangle) + SIDE_CA.service(triangle);
		}
	},
	HALF_PERIMETER {
		@Override
		public double service(Triangle triangle) {
			return PERIMETER.service(triangle) / 2;
		}
	},
	SQUARE {
		@Override
		public double service(Triangle triangle) {
			return Math.sqrt(
					HALF_PERIMETER.service(triangle) * ((HALF_PERIMETER.service(triangle) - SIDE_AB.service(triangle))
							* (HALF_PERIMETER.service(triangle) - SIDE_BC.service(triangle))
							* (HALF_PERIMETER.service(triangle) - SIDE_CA.service(triangle))));
		}
	},
	SIDE_AB {
		@Override
		public double service(Triangle triangle) {
			double a = triangle.getDotA().getCoordinateX() - triangle.getDotB().getCoordinateX();
			double b = triangle.getDotA().getCoordinateY() - triangle.getDotB().getCoordinateY();
			return Math.hypot(a, b);
		}
	},
	SIDE_BC {
		@Override
		public double service(Triangle triangle) {
			double b = triangle.getDotB().getCoordinateX() - triangle.getDotC().getCoordinateX();
			double c = triangle.getDotB().getCoordinateY() - triangle.getDotC().getCoordinateY();
			return Math.hypot(b, c);
		}
	},
	SIDE_CA {
		@Override
		public double service(Triangle triangle) {
			double c = triangle.getDotC().getCoordinateX() - triangle.getDotA().getCoordinateX();
			double a = triangle.getDotC().getCoordinateY() - triangle.getDotA().getCoordinateY();
			return Math.hypot(c, a);
		}
	},
	ANGLE_A {
		@Override
		public double service(Triangle triangle) {
			return Math.round(Math.toDegrees(Math.acos((SIDE_AB.service(triangle) * SIDE_AB.service(triangle)
					+ SIDE_CA.service(triangle) * SIDE_CA.service(triangle)
					- SIDE_BC.service(triangle) * SIDE_BC.service(triangle))
					/ (2 * SIDE_AB.service(triangle) * SIDE_CA.service(triangle)))));
		}
	},
	ANGLE_B {
		@Override
		public double service(Triangle triangle) {
			return Math.round(Math.toDegrees(Math.acos((SIDE_AB.service(triangle) * SIDE_AB.service(triangle)
					+ SIDE_BC.service(triangle) * SIDE_BC.service(triangle)
					- SIDE_CA.service(triangle) * SIDE_CA.service(triangle))
					/ (2 * SIDE_AB.service(triangle) * SIDE_BC.service(triangle)))));
		}
	},
	ANGLE_C {
		@Override
		public double service(Triangle triangle) {
			return Math.round(Math.toDegrees(Math.acos((SIDE_BC.service(triangle) * SIDE_BC.service(triangle)
					+ SIDE_CA.service(triangle) * SIDE_CA.service(triangle)
					- SIDE_AB.service(triangle) * SIDE_AB.service(triangle))
					/ (2 * SIDE_BC.service(triangle) * SIDE_CA.service(triangle)))));
		}
	};
}