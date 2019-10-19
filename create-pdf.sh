#!/usr/bin/env bash

asciidoctor-pdf -a rouge-style=github book-mvnref.asciidoc
asciidoctor -a rouge-style=github book-mvnref.asciidoc