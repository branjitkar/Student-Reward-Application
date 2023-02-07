package com.sa.studentreward.service;

import com.sa.studentreward.dto.StudentRewardDto;

public interface IRewardEventService {

    void buyRewards(StudentRewardDto studentRewardDto) throws Exception;

    void adminAdministerRewards(StudentRewardDto studentRewardDto) throws Exception;
}
