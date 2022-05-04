package ex3;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class Builder {

        private final String title;
        private final int year;
        private Person director = new Person("", 0);
        private Person writer = new Person("", 0);
        private String series = "";
        private List<Person> cast = new ArrayList<>();
        private List<Place> locations = new ArrayList<>();
        private List<String> languages = new ArrayList<>();
        private List<String> genres = new ArrayList<>();
        private boolean isTelevision = false;
        private boolean isNetflix = false;
        private boolean isIndependent = false;

        // Builder Methods
        public Builder(String movieTitle, int movieYear) {
            this.title = movieTitle;
            this.year = movieYear;
        }

        public Builder director (Person p) {
            this.director = p;
            return this;
        }

        public Builder writer(Person p){
            this.writer = p;
            return this;
        }

        public Builder series(String s){
            this.series = s;
            return this;
        }

        public Builder cast(List<Person> list){
            this.cast = list;
            return this;
        }

        public Builder locations(List<Place> list){
            this.locations = list;
            return this;
        }

        public Builder languages(List<String> list){
            this.languages = list;
            return this;
        }

        public Builder genres(List<String> list){
            this.genres = list;
            return this;
        }

        public Builder isTelevision(boolean value){
            this.isTelevision = value;
            return this;
        }

        public Builder isNetflix(boolean value){
            this.isNetflix = value;
            return this;
        }

        public Builder isIndependent(boolean value){
            this.isIndependent = value;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }
    }

    public Movie(Builder build){
        title = build.title;
        year = build.year;
        director = build.director;
        writer = build.writer;
        series = build.series;
        cast = build.cast;
        locations = build.locations;
        languages = build.languages;
        genres = build.genres;
        isTelevision = build.isTelevision;
        isNetflix = build.isNetflix;
        isIndependent = build.isIndependent;
    }
}
