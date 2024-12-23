package mk.ukim.finki.lab1.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab1.model.Album;
import mk.ukim.finki.lab1.model.Artist;
import mk.ukim.finki.lab1.model.Song;
import mk.ukim.finki.lab1.repository.AlbumRepository;
import mk.ukim.finki.lab1.repository.ArtistRepository;
import mk.ukim.finki.lab1.repository.SongRepository;
import org.springframework.stereotype.Component;

@Component
public class DataHolder {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    public DataHolder(AlbumRepository albumRepository, ArtistRepository artistRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @PostConstruct
    public void init() {
        Album toPimpAButterfly = new Album("To Pimp a Butterfly", "Hip-hop", "2015");
        Album aM = new Album("AM", "HindiRock", "2013");
        Album abbeyRoad = new Album("Abbey Road", "Rock", "1969");
        Album normanFuckingRockwell = new Album("Norman Fucking Rockwell", "Soft Rock", "2019");
        Album dooWopsHooligans = new Album("Doo-Wops & Hooligans", "R&B/Soul", "2010");

        albumRepository.save(toPimpAButterfly);
        albumRepository.save(aM);
        albumRepository.save(abbeyRoad);
        albumRepository.save(normanFuckingRockwell);
        albumRepository.save(dooWopsHooligans);

        artistRepository.save(new Artist("Kendrick", "Lamar", "bio1"));
        artistRepository.save(new Artist("Arctic", "Monkeys", "bio2"));
        artistRepository.save(new Artist("The", "Beatles", "bio3"));
        artistRepository.save(new Artist("Lana Del", "Rey", "bio4"));
        artistRepository.save(new Artist("Bruno", "Mars", "bio5"));

        songRepository.save(new Song("Alright", "Hip-hop", 2015, toPimpAButterfly));
        songRepository.save(new Song("Do I Wanna Know?", "HindiRock", 2013, aM));
        songRepository.save(new Song("Come Together", "Rock", 1969, abbeyRoad));
        songRepository.save(new Song("Mariners Apartment Complex", "Soft Rock", 2019, normanFuckingRockwell));
        songRepository.save(new Song("Grenade", "R&B/Soul", 2010, dooWopsHooligans));
    }
}
