

INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('BANHDAP-002'   ,N'BÁNH ĐẬP',70.000,0,1,20,4,'banh_dap');
INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('BANHDAPTOMCHAY-003'   ,N'BÁNH ĐẬP TÔM CHÁY',70.000,0,1,20,4,'banh_dap_tom_chay');
INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('LUONXUCBANHRAN-004'   ,N'LƯƠN XÚC BÁNH TRÁN',70.000,0,1,20,4,'luon_xuc_banh_tra');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('NHAMHUE-005'   ,N'NHẤM HUẾ',70.000,0,1,20,4,'nham_hue');
 
 
 
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('THAPCAMNUONG-006'   ,N'THẬP CẨM NƯỚNG',420000,0,1,10,3,'thap_cam_nuong');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('CUAFARCI-007'   ,N'CUA FARCI',120000,0,1,10,3,'cua_farci');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('CHAOTOM-008'   ,N'CHẠO TÔM',120000,0,1,10,3,'chao_tom');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('CANGCUABOCCHAO-009'   ,N'CÀNG CUA BỌC CHẠO',180000,0,1,10,3,'cang_cua_boc_chao');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('TOMNUONG-0010'   ,N'TÔM NƯỚNG',130000,0,1,10,3,'tom_nuong_banh_hoi ');
 
 
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('SALAUCVIT-011'   ,N'SALADE ỨC VỊT',180000,0,1,10,3,'salades_uc_vit');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('SACAHOI-012'   ,N'SALADE CÁ HỒI',180000,0,1,10,3,'salades_ca_hoi');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('SALAPRO-013'   ,N'SALADE PROVENÇALE',180000,0,1,10,3,'salades_dong_pho');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('GANVIT-014'   ,N'GAN VỊT PHÁP',600000,0,1,10,3,'gan_vit_phap');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('CAHOI-0015'   ,N'CÁ HỒI THÌA LÀ',250000,0,1,10,3,'ca_hoi_thia_la');
 
 
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('BUNBOHUE-016'   ,N'BÚN BÒ HUẾ',110000,0,1,10,1,'==bun_bo_hue');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('BUNSUONG-017'   ,N'BÚN SUÔNG',110000,0,1,10,1,'=bun_suong');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('SUICAO-018'   ,N'SỦI CẢO NƯỚC',180000,0,1,10,1,'=sui_cao_nuoc');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('MIQUANG-019'   ,N'MÌ QUẢNG',11000,0,1,10,1,'=mi_quang');
 INSERT INTO [FoodTBL]    ([FoodID],[FoodName],[FoodPrice],[Promotion],[InStock],[FoodQuantity],[FoodTypeId],FoodImg)
 VALUES  ('PHOGA-0020'   ,N'PHỞ GÀ',110000,0,1,10,1,'=pho_ga');
 
 
 INSERT INTO [StatusTBL]([StatusID],[StatusType])VALUES(1,'Waitting');
 INSERT INTO [StatusTBL]([StatusID],[StatusType])VALUES(2,'Done');
 INSERT INTO [StatusTBL]([StatusID],[StatusType])VALUES(3,'Delivered');
 INSERT INTO [StatusTBL]([StatusID],[StatusType])VALUES(4,'Reject');
 
 INSERT INTO [AccountTBL]([Account],[Password],[EmployeeID])VALUES('accounttest','123456','EMP001');


INSERT INTO [RoleTBL]([RoleID],[RoleName])VALUES(1,'Admin');
INSERT INTO [RoleTBL]([RoleID],[RoleName])VALUES(2,'Employee');
INSERT INTO [RoleTBL]([RoleID],[RoleName])VALUES(3,'Cooker');


INSERT INTO [EmployeeTBL]([EmployeeId],[EmployeeName],[EmployeeAddress],[EmployeePhone],[RoleID])
VALUES('EMP001','God Tuyen','Ha Noi','0988888888',1);





