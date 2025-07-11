package com.px.partybuild.timetask;

import com.px.partybuild.AppConfig;
import com.px.partybuild.service.*;
import com.px.partybuild.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
@Slf4j
public class syncTask {
    @Autowired
    private AppConfig appConfig;

    @Autowired
    private UserService userService;

    @Autowired
    private PEUserService peUserService;

    @Autowired
    private PartyService partyService;

    @Autowired
    private DateUtils dateUtils;

    @Autowired
    private PartyUserService partyUserService;

    @Scheduled(cron = "${appconfig.sync-cron-usercount}")
    //@Scheduled(cron = "0 */1 * * * ?")
    public void updatePartyusercount() {
        if (appConfig.isBackService) {
            log.info("updatePartyusercount执行begin");
            try {

                userService.procUpdatePartyusercount();

            } catch (Exception e) {
                log.info("updatePartyusercount执行错误：" + e.getMessage());
            }
            log.info("updatePartyusercount执行end");
        }
    }

    @Scheduled(cron = "${appconfig.sync-cron-userage}")
    //@Scheduled(cron = "0 */1 * * * ?")
    public void updateUserage() {
        if (appConfig.isBackService) {
            log.info("updateUserage执行begin");
            try {
                userService.updateUserage();
            } catch (Exception e) {
                log.info("updateUserage执行错误：" + e.getMessage());
            }
            log.info("updateUserage执行end");
        }
    }

    //@Scheduled(cron="${appconfig.sync-cron-userage}")
    @Scheduled(cron = "0 0 8 * * ?")
    //@Scheduled(cron = "0 */1 * * * ?")
    public void updateJoinuserCode() {
        if (appConfig.isBackService) {
            log.info("updateJoinuserCode执行begin");
            try {
                peUserService.updateJoinuserCode();
            } catch (Exception e) {
                log.info("updateJoinuserCode执行错误：" + e.getMessage());
            }
            log.info("updateJoinuserCode执行end");
        }
    }


    @Scheduled(cron = "0 0 8 * * ?")
    //@Scheduled(cron = "0 */1 * * * ?")
    public void handlePartyData() {
        if (appConfig.isBackService) {
            log.info("handlePartyData执行begin");
            try {
                partyService.handlePartyData();
            } catch (Exception e) {
                log.info("handlePartyData执行错误：" + e.getMessage());
            }
            log.info("handlePartyData执行end");
        }
    }


    @Scheduled(cron = "${appconfig.sync-cron-updateUserparty}")
    public void asyncUserPartyOfMonth() {
        if (appConfig.isBackService) {
            log.info("更新党员每月所属党支部begin");
            LocalDate nowDate = dateUtils.dateToLocalDate(new Date());
            Integer startYear = 2022;
            Integer endYear = nowDate.getYear();

            for (int y = startYear; y <= endYear; y++) {
                for (int m = 1; m <= 12; m++) {
                    try {
                        Integer yearMonth = Integer.parseInt(y + String.format("%02d", m));
                        partyUserService.batchInsertUserPartyOfMonth(yearMonth);
                        /*partyUserService.batchUpdateUserPartyOfMonth(yearMonth);*/
                    } catch (Exception e) {
                        log.info("更新党员每月所属党支部错误：年份 " + y + "，月份 " + m + "，" + e.getMessage());
                    }
                }
            }

            log.info("更新党员每月所属党支部end");
        }
    }

}
