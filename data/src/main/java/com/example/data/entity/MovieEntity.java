package com.example.data.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class MovieEntity implements Parcelable
{
    private String id;
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("backdrop_path")
    private String backdropPath;
    private String title;
    @SerializedName("vote_average")
    private double voteAverage;

    public MovieEntity()
    {

    }

    protected MovieEntity(Parcel in)
    {
        id = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
        posterPath = in.readString();
        backdropPath = in.readString();
        title = in.readString();
        voteAverage = in.readDouble();
    }

    public static final Creator<MovieEntity> CREATOR = new Creator<MovieEntity>()
    {
        @Override
        public MovieEntity createFromParcel(Parcel in)
        {
            return new MovieEntity(in);
        }

        @Override
        public MovieEntity[] newArray(int size)
        {
            return new MovieEntity[size];
        }
    };

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getOverview()
    {
        return overview;
    }

    public void setOverview(String overview)
    {
        this.overview = overview;
    }

    public String getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath()
    {
        return posterPath;
    }

    public void setPosterPath(String posterPath)
    {
        this.posterPath = posterPath;
    }

    public String getBackdropPath()
    {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath)
    {
        this.backdropPath = backdropPath;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public double getVoteAverage()
    {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage)
    {
        this.voteAverage = voteAverage;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(overview);
        parcel.writeString(releaseDate);
        parcel.writeString(posterPath);
        parcel.writeString(backdropPath);
        parcel.writeString(title);
        parcel.writeDouble(voteAverage);
    }
}
