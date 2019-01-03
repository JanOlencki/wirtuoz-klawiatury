package pl.olencki.jan.keyboardvirtuoso.gamesdata;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CharChallengeDao {
    @Query("SELECT * FROM CharChallengeData")
    List<CharChallengeData> findAll();

    @Query("SELECT * FROM CharChallengeData WHERE id = :charChallengeId")
    CharChallengeData findById(long charChallengeId);

    @Query("SELECT * FROM CharChallengeData WHERE gameId = :gameId")
    List<CharChallengeData> findByGameId(long gameId);

    @Insert
    long insert(CharChallengeData charChallenge);

    @Insert
    long[] insertMultiple(List<CharChallengeData> charChallenges);

    @Delete
    int delete(CharChallengeData charChallenge);

    @Delete
    int deleteMultiple(List<CharChallengeData> charChallenges);

    @Query("DELETE FROM CharChallengeData WHERE gameId = :gameId")
    int deleteByGameId(long gameId);
}