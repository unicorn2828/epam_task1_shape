package by.kononov.shape.action.impl;

import static by.kononov.shape.data.impl.TriangleDataImpl.ANGLE_A;
import static by.kononov.shape.data.impl.TriangleDataImpl.ANGLE_B;
import static by.kononov.shape.data.impl.TriangleDataImpl.ANGLE_C;
import static by.kononov.shape.data.impl.TriangleDataImpl.SIDE_AB;
import static by.kononov.shape.data.impl.TriangleDataImpl.SIDE_BC;
import static by.kononov.shape.data.impl.TriangleDataImpl.SIDE_CA;

import by.kononov.shape.action.TriangleAction;
import by.kononov.shape.entity.Triangle;

public class TriangleActionImpl implements TriangleAction{
	@Override
	public boolean isIsoscelesTriangle(Triangle triangle) {
		return SIDE_AB.service(triangle) == SIDE_BC.service(triangle)
				|| SIDE_BC.service(triangle) == SIDE_CA.service(triangle)
				|| SIDE_CA.service(triangle) == SIDE_AB.service(triangle);
	}

	@Override
	public boolean isEquilateralTriangle(Triangle triangle) {
		return ANGLE_A.service(triangle) == 60 && ANGLE_B.service(triangle) == 60 && ANGLE_C.service(triangle) == 60;
	}

	@Override
	public boolean isRectangularTriangle(Triangle triangle) {
		return ANGLE_A.service(triangle) == 90 || ANGLE_B.service(triangle) == 90 || ANGLE_C.service(triangle) == 90;
	}

	@Override
	public boolean isAcuteTriangle(Triangle triangle) {
		return ANGLE_A.service(triangle) < 90 && ANGLE_B.service(triangle) < 90 && ANGLE_C.service(triangle) < 90;
	}

	@Override
	public boolean isObtuseTriangle(Triangle triangle) {
		return ANGLE_A.service(triangle) > 90 || ANGLE_B.service(triangle) > 90 || ANGLE_C.service(triangle) > 90;
	}
}