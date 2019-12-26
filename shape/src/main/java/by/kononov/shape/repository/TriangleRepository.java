package by.kononov.shape.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;

import by.kononov.shape.entity.Triangle;
import by.kononov.shape.sort.TriangleComparator;
import by.kononov.shape.specification.TriangleSpecification;

public class TriangleRepository{
	private final static TriangleRepository instance = new TriangleRepository();

	private List<Triangle> repositoryList = new ArrayList<>();

	private TriangleRepository() {
	}

	public static TriangleRepository getInstance() {
		return instance;
	}

	public Optional<List<Triangle>> query(TriangleSpecification specification) {
		return Optional.of(repositoryList.stream().filter(specification::service).collect(Collectors.toList()));
	}

	public void sort(TriangleComparator comparator) {
		repositoryList.sort(comparator.getComparator());
	}

	public Triangle addTriangle(Triangle triangle) {
		repositoryList.add(triangle);
		return triangle;
	}

	public Triangle removeTriangle(Triangle triangle) {
		repositoryList.remove(triangle);
		return triangle;
	}

	public List<Triangle> receiveAll() {
		return Collections.unmodifiableList(repositoryList);
	}

	public boolean removeAll() {
		repositoryList.clear();
		return repositoryList.isEmpty();
	}

	public boolean update(Triangle triangle) {
		ListIterator<Triangle> iterator = repositoryList.listIterator();
		while (iterator.hasNext()) {
			Triangle next = iterator.next();
			if (next.equals(triangle)) {
				iterator.set(triangle);
				return true;
			}
		}
		return false;
	}
}