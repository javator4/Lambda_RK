package pl.sda.lambda;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Album {

    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;
}
