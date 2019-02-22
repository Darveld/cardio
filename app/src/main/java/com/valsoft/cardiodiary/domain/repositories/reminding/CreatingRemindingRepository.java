package com.valsoft.cardiodiary.domain.repositories.reminding;

import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.Reminding;

import java.util.List;

import io.reactivex.Completable;

public interface CreatingRemindingRepository {

    Completable insertReminding(Reminding reminding, List<MedicalDrug> list);

}
