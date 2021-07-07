package com.example.m5_projectsetupuserstoriesandconfiguration.model;

/**
 * Interface for concrete interactors
 */
abstract class Interactor {
    private final Repository theRepository;

    Interactor(Repository repo) {theRepository = repo;}

    Repository getRepository() {return theRepository;}

}
