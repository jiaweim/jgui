/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jgui.javafx.tableview.music;

import javafx.beans.property.*;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 09 Jan 2018, 6:56 PM
 */
public class Music
{
    //Properties
    private SimpleStringProperty artist = new SimpleStringProperty();
    private ObjectProperty albumArt = new SimpleObjectProperty();
    private StringProperty title = new SimpleStringProperty();
    private IntegerProperty rating = new SimpleIntegerProperty();

    public Music(String artist, Album album, String title, Integer rating)
    {
        setArtist(artist);
        setAlbum(album);
        setTitle(title);
        setRating(rating);
    }

    public String getArtist()
    {
        return artist.get();
    }

    //For Artist
    public void setArtist(String art)
    {
        artist.set(art);
    }

    public StringProperty artistProperty()
    {
        return artist;
    }

    public Object getAlbum()
    {
        return albumArt.get();
    }

    //For Album
    public void setAlbum(Album alb)
    {
        albumArt.set(alb);
    }

    public ObjectProperty albumProperty()
    {
        return albumArt;
    }

    public String getTitle()
    {
        return title.get();
    }

    //For Title
    public void setTitle(String tit)
    {
        title.set(tit);
    }

    public StringProperty titleProperty()
    {
        return title;
    }

    public Integer getRating()
    {
        return rating.get();
    }

    //For Rating
    public void setRating(int rat)
    {
        rating.set(rat);
    }

    public IntegerProperty ratingProperty()
    {
        return rating;
    }
}
