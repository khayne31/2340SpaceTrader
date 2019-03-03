package com.example.m5_projectsetupuserstoriesandconfiguration.model;

/**
 * Interface for concrete interactors
 */
public abstract class Interactor {
    private Repository theRepository;

    protected Interactor(Repository repo) {theRepository = repo;}

    protected Repository getRepository() {return theRepository;}

}
