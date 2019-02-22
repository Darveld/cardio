package com.valsoft.cardiodiary.domain.repositories.dailyindexes;

import java.util.Date;

public interface CreatingDailyIndexesRepository {
   void createDailyIndexes(int feelings, int activity, int mood, int anxiety, int irritation, int concentration, int fatigue, int psychoemotionalStress, int sleep, Date date, long statisticId);
}
