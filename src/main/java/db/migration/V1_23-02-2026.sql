select constraint_name from information_schema.constraint_column_usage where table_name = 'acess_user' and column_name = 'acess_id'
                                                                         and constraint_name <> 'unique_acess_user';

alter table acess_user drop CONSTRAINT "ukar4gmb0xyfh6xxugjynjcs6cq";