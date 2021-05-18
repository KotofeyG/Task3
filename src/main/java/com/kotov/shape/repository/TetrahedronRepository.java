package com.kotov.shape.repository;

import com.kotov.shape.entity.Tetrahedron;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TetrahedronRepository {
    private final static TetrahedronRepository instance = new TetrahedronRepository();
    private final List<Tetrahedron> storage = new ArrayList<>();

    private TetrahedronRepository() {
    }

    public static TetrahedronRepository getInstance() {
        return instance;
    }

    public List<Tetrahedron> query(Specification specification) {
        List<Tetrahedron> list = new ArrayList<>();
        for (Tetrahedron tetrahedron : storage) {
            if (specification.specify(tetrahedron)) {
                list.add(tetrahedron);
            }
        }
        return list;
    }

    public List<Tetrahedron> queryStream(Specification specification) {
        List<Tetrahedron> list = storage.stream().filter(specification::specify).collect(Collectors.toList());
        return list;
    }

    public List<Tetrahedron> sort(Comparator<? super Tetrahedron> comparator) {
        List<Tetrahedron> sortedList = new ArrayList<>(storage);
        sortedList.sort(comparator);
        return sortedList;
    }

    public List<Tetrahedron> sortStream(Comparator<? super Tetrahedron> comparator) {
        List<Tetrahedron> sortedList = storage.stream().sorted(comparator).collect(Collectors.toList());
        return sortedList;
    }

    public boolean add(Tetrahedron tetrahedron) {
        return storage.add(tetrahedron);
    }

    public void add(int index, Tetrahedron tetrahedron) {
        storage.add(index, tetrahedron);
    }

    public boolean addAll(Collection<? extends Tetrahedron> collection) {
        return storage.addAll(collection);
    }

    public boolean addAll(int index, Collection<? extends Tetrahedron> collection) {
        return storage.addAll(index, collection);
    }

    public boolean remove(Tetrahedron tetrahedron) {
        return storage.remove(tetrahedron);
    }

    public Tetrahedron remove(int index) {
        return storage.remove(index);
    }

    public boolean removeAll(Collection<? extends Tetrahedron> collection) {
        return storage.removeAll(collection);
    }

    public Tetrahedron get(int index) {
        return storage.get(index);
    }

    public boolean contains(Tetrahedron tetrahedron) {
        return storage.contains(tetrahedron);
    }

    public boolean containsAll(Collection<? extends Tetrahedron> collection) {
        return storage.containsAll(collection);
    }

    public void clear() {
        storage.clear();
    }

    public int size() {
        return storage.size();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }
}