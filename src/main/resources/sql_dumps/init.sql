/*
add roles 1st
*/
REPLACE INTO `role` (`id`, `created_on`, `updated_on`, `editable`, `deleted`, `expired`, `enabled`, `role_name`, `editable_by`, `updated_by`) VALUES
	(1, '2019-01-25 08:40:57', '2019-01-26 01:48:38', 0, 0, 0, 0, 'SYSTEM', NULL, NULL),
	(2, '2019-01-25 08:40:57', '2019-01-26 01:48:38', 0, 0, 0, 0, 'SUPER_ADMIN', NULL, NULL),
	(3, '2019-01-25 08:40:57', '2019-01-26 01:48:38', 0, 0, 0, 0, 'ADMIN', NULL, NULL),
	(4, '2019-01-25 08:40:57', '2019-01-26 01:48:38', 0, 0, 0, 0, 'AUDITOR', NULL, NULL),
	(5, '2019-01-25 08:40:57', '2019-01-26 01:48:38', 0, 0, 0, 0, 'GUEST', NULL, NULL),
	(6, '2019-01-25 08:40:57', '2019-01-26 01:48:38', 0, 0, 0, 0, 'USER', NULL, NULL);

/**
add the 1st user 1st
*/
REPLACE INTO `user` (`id`, `username`, `password`, `created_on`, `updated_on`, `check_password_history`, `deleted`, `editable`, `enabled`, `expired`, `locked`, `verified`, `editable_by`, `updated_by`, `role`) VALUES
	(1, 'system', '$2a$10$4AywUVWKTuxbiT.vV3.vSOel4rEOWQZ5Opv0MUL7y0MbX48DkeL5q', '2019-01-25 08:40:57', '2019-01-26 01:48:38', 0, 0, 0, 1, 0, 0, 1, NULL, NULL, 1)

REPLACE INTO `user` (`id`, `username`, `password`, `created_on`, `updated_on`, `check_password_history`, `deleted`, `editable`, `enabled`, `expired`, `locked`, `verified`, `editable_by`, `updated_by`, `role`) VALUES
	(2, 'super-admin', '$2a$10$2foDdcygEaI4d7XvX2P.quZ1DjUVovdDFYu1NcZWDL1vxkcIaFiDa', '2019-01-25 21:39:24', '2019-01-26 01:40:48', 0, 0, 0, 1, 0, 0, 1, NULL, 1, 2)
	(3, 'admin', '$2a$10$YI9x2VDsz8DpcY20dbJXC.QbpudxDqAKJyCmUO4Hctug0QANbckZa', '2019-01-25 21:39:24', '2019-01-26 01:40:48', 0, 0, 0, 1, 0, 0, 1, NULL, 1, 3);


UPDATE `role` SET `updated_by`='1';