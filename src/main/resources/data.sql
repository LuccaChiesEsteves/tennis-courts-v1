insert into guest(id, name) values(null, 'Roger Federer');
insert into guest(id, name) values(null, 'Rafael Nadal');

insert into tennis_court(id, name) values(null, 'Roland Garros - Court Philippe-Chatrier');
insert into tennis_court(id, name) values(null, 'Germânia - Porto Alegre');

insert
    into
        schedule
        (id, start_date_time, end_date_time, tennis_court_id)
    values
        (null, '2022-12-20T20:00:00.0', '2022-02-20T21:00:00.0', 1);

insert
into
    schedule
(id, start_date_time, end_date_time, tennis_court_id)
values
(null, '2022-12-21T22:00:00.0', '2022-02-21T23:00:00.0', 1);

