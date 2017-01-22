package com.example.sajalnarang.smsdemo;

import java.util.List;

/**
 * Created by sajalnarang on 21/1/17.
 */

public class GsonModels {
    public class MenuResponse {
        private List<Result> results = null;
        private Integer count;

        public MenuResponse(List<Result> results, Integer count) {
            this.results = results;
            this.count = count;
        }

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }
    public class Result {
        private String id;
        private String day;
        private String breakfast;
        private String lunch;
        private String tiffin;
        private String dinner;

        public Result(String id, String day, String breakfast, String lunch, String tiffin, String dinner) {
            this.id = id;
            this.day = day;
            this.breakfast = breakfast;
            this.lunch = lunch;
            this.tiffin = tiffin;
            this.dinner = dinner;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getBreakfast() {
            return breakfast;
        }

        public void setBreakfast(String breakfast) {
            this.breakfast = breakfast;
        }

        public String getLunch() {
            return lunch;
        }

        public void setLunch(String lunch) {
            this.lunch = lunch;
        }

        public String getTiffin() {
            return tiffin;
        }

        public void setTiffin(String tiffin) {
            this.tiffin = tiffin;
        }

        public String getDinner() {
            return dinner;
        }

        public void setDinner(String dinner) {
            this.dinner = dinner;
        }
    }
}
