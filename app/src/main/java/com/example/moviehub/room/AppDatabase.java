package com.example.moviehub.room;

import com.example.moviehub.model.ForBookmark;
import com.example.moviehub.model.MovieInfo;
import com.example.moviehub.model.Result;
import com.example.moviehub.room.dao.ForBookmarkDao;
import com.example.moviehub.room.dao.MovieInfoDao;
import com.example.moviehub.room.dao.ResultDao;
import com.example.moviehub.room.typeconverter.BelongsToCollectionConverter;
import com.example.moviehub.room.typeconverter.GenreConverters;
import com.example.moviehub.room.typeconverter.IntegerConverter;
import com.example.moviehub.room.typeconverter.LongConverters;
import com.example.moviehub.room.typeconverter.MTvConverter;
import com.example.moviehub.room.typeconverter.ProductionCompanyConverter;
import com.example.moviehub.room.typeconverter.ProductionCountryConverter;
import com.example.moviehub.room.typeconverter.SpokenLanguageConverter;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Result.class, MovieInfo.class,ForBookmark.class}, version = 1)
@TypeConverters(
        {
                LongConverters.class,
                BelongsToCollectionConverter.class,
                GenreConverters.class,
                IntegerConverter.class,
                ProductionCompanyConverter.class,
                ProductionCountryConverter.class,
                SpokenLanguageConverter.class,
                MTvConverter.class
        }
)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ResultDao getResultDao();
    public abstract MovieInfoDao getMovieInfoDao();
    public abstract ForBookmarkDao getForBookmarkDao();

}
