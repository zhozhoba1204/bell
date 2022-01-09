package ru.bellintegrator.practice.exception;

/**
 * Dto для представления объектов при успешном выполнении метода
 * @param <E>
 */
public class DataDto<E> {
    private E data;

    public DataDto(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
