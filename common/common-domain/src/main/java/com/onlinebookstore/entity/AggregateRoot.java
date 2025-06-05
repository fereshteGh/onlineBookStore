package com.onlinebookstore.entity;

public abstract class AggregateRoot<T extends Record & Identity> extends BaseEntity<T>{
}
