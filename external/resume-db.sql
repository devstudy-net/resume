--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-04-25 13:42:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2233 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 183 (class 1259 OID 16730)
-- Name: certificate; Type: TABLE; Schema: public; Owner: resume
--

CREATE TABLE certificate (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    name character varying(50) NOT NULL,
    large_url character varying(255) NOT NULL,
    small_url character varying(255) NOT NULL
);


ALTER TABLE certificate OWNER TO resume;

--
-- TOC entry 192 (class 1259 OID 16760)
-- Name: certificate_seq; Type: SEQUENCE; Schema: public; Owner: resume
--

CREATE SEQUENCE certificate_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE certificate_seq OWNER TO resume;

--
-- TOC entry 198 (class 1259 OID 16784)
-- Name: course; Type: TABLE; Schema: public; Owner: resume
--

CREATE TABLE course (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    name character varying(60) NOT NULL,
    school character varying(60) NOT NULL,
    finish_date date
);


ALTER TABLE course OWNER TO resume;

--
-- TOC entry 199 (class 1259 OID 16787)
-- Name: course_seq; Type: SEQUENCE; Schema: public; Owner: resume
--

CREATE SEQUENCE course_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE course_seq OWNER TO resume;

--
-- TOC entry 195 (class 1259 OID 16768)
-- Name: education; Type: TABLE; Schema: public; Owner: resume
--

CREATE TABLE education (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    summary character varying(100) NOT NULL,
    begin_year integer NOT NULL,
    finish_year integer,
    university text NOT NULL,
    faculty character varying(255) NOT NULL
);


ALTER TABLE education OWNER TO resume;

--
-- TOC entry 191 (class 1259 OID 16758)
-- Name: education_seq; Type: SEQUENCE; Schema: public; Owner: resume
--

CREATE SEQUENCE education_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE education_seq OWNER TO resume;

--
-- TOC entry 182 (class 1259 OID 16727)
-- Name: hobby; Type: TABLE; Schema: public; Owner: resume
--

CREATE TABLE hobby (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    name character varying(30) NOT NULL
);


ALTER TABLE hobby OWNER TO resume;

--
-- TOC entry 190 (class 1259 OID 16756)
-- Name: hobby_seq; Type: SEQUENCE; Schema: public; Owner: resume
--

CREATE SEQUENCE hobby_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hobby_seq OWNER TO resume;

--
-- TOC entry 181 (class 1259 OID 16723)
-- Name: language; Type: TABLE; Schema: public; Owner: resume
--

CREATE TABLE language (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    name character varying(30) NOT NULL,
    level character varying(18) NOT NULL,
    type character varying(7) DEFAULT 0 NOT NULL
);


ALTER TABLE language OWNER TO resume;

--
-- TOC entry 189 (class 1259 OID 16754)
-- Name: language_seq; Type: SEQUENCE; Schema: public; Owner: resume
--

CREATE SEQUENCE language_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE language_seq OWNER TO resume;

--
-- TOC entry 193 (class 1259 OID 16762)
-- Name: persistent_logins; Type: TABLE; Schema: public; Owner: resume
--

CREATE TABLE persistent_logins (
    username character varying(64) NOT NULL,
    series character varying(64) NOT NULL,
    token character varying(64) NOT NULL,
    last_used timestamp without time zone NOT NULL
);


ALTER TABLE persistent_logins OWNER TO resume;

--
-- TOC entry 184 (class 1259 OID 16736)
-- Name: practic; Type: TABLE; Schema: public; Owner: resume
--

CREATE TABLE practic (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    "position" character varying(100) NOT NULL,
    company character varying(100) NOT NULL,
    begin_date date NOT NULL,
    finish_date date,
    responsibilities text NOT NULL,
    demo character varying(255),
    src character varying(255)
);


ALTER TABLE practic OWNER TO resume;

--
-- TOC entry 188 (class 1259 OID 16752)
-- Name: practic_seq; Type: SEQUENCE; Schema: public; Owner: resume
--

CREATE SEQUENCE practic_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE practic_seq OWNER TO resume;

--
-- TOC entry 197 (class 1259 OID 16777)
-- Name: profile; Type: TABLE; Schema: public; Owner: resume
--

CREATE TABLE profile (
    id bigint NOT NULL,
    uid character varying(100) NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    birth_day date,
    phone character varying(20),
    email character varying(100),
    country character varying(60),
    city character varying(100),
    objective text,
    summary text,
    large_photo character varying(255),
    small_photo character varying(255),
    info text,
    password character varying(255) NOT NULL,
    completed boolean NOT NULL,
    created timestamp(0) without time zone DEFAULT now() NOT NULL,
    skype character varying(80),
    vkontakte character varying(255),
    facebook character varying(255),
    linkedin character varying(255),
    github character varying(255),
    stackoverflow character varying(255)
);


ALTER TABLE profile OWNER TO resume;

--
-- TOC entry 196 (class 1259 OID 16774)
-- Name: profile_restore; Type: TABLE; Schema: public; Owner: resume
--

CREATE TABLE profile_restore (
    id bigint NOT NULL,
    token character varying(255) NOT NULL
);


ALTER TABLE profile_restore OWNER TO resume;

--
-- TOC entry 186 (class 1259 OID 16748)
-- Name: profile_seq; Type: SEQUENCE; Schema: public; Owner: resume
--

CREATE SEQUENCE profile_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE profile_seq OWNER TO resume;

--
-- TOC entry 185 (class 1259 OID 16742)
-- Name: skill; Type: TABLE; Schema: public; Owner: resume
--

CREATE TABLE skill (
    id bigint NOT NULL,
    id_profile bigint NOT NULL,
    category character varying(50) NOT NULL,
    value text NOT NULL
);


ALTER TABLE skill OWNER TO resume;

--
-- TOC entry 194 (class 1259 OID 16765)
-- Name: skill_category; Type: TABLE; Schema: public; Owner: resume
--

CREATE TABLE skill_category (
    id bigint NOT NULL,
    category character varying(50) NOT NULL
);


ALTER TABLE skill_category OWNER TO resume;

--
-- TOC entry 187 (class 1259 OID 16750)
-- Name: skill_seq; Type: SEQUENCE; Schema: public; Owner: resume
--

CREATE SEQUENCE skill_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE skill_seq OWNER TO resume;

--
-- TOC entry 2209 (class 0 OID 16730)
-- Dependencies: 183
-- Data for Name: certificate; Type: TABLE DATA; Schema: public; Owner: resume
--

COPY certificate (id, id_profile, name, large_url, small_url) FROM stdin;
\.


--
-- TOC entry 2234 (class 0 OID 0)
-- Dependencies: 192
-- Name: certificate_seq; Type: SEQUENCE SET; Schema: public; Owner: resume
--

SELECT pg_catalog.setval('certificate_seq', 1, false);


--
-- TOC entry 2224 (class 0 OID 16784)
-- Dependencies: 198
-- Data for Name: course; Type: TABLE DATA; Schema: public; Owner: resume
--

COPY course (id, id_profile, name, school, finish_date) FROM stdin;
\.


--
-- TOC entry 2235 (class 0 OID 0)
-- Dependencies: 199
-- Name: course_seq; Type: SEQUENCE SET; Schema: public; Owner: resume
--

SELECT pg_catalog.setval('course_seq', 1, false);


--
-- TOC entry 2221 (class 0 OID 16768)
-- Dependencies: 195
-- Data for Name: education; Type: TABLE DATA; Schema: public; Owner: resume
--

COPY education (id, id_profile, summary, begin_year, finish_year, university, faculty) FROM stdin;
\.


--
-- TOC entry 2236 (class 0 OID 0)
-- Dependencies: 191
-- Name: education_seq; Type: SEQUENCE SET; Schema: public; Owner: resume
--

SELECT pg_catalog.setval('education_seq', 1, false);


--
-- TOC entry 2208 (class 0 OID 16727)
-- Dependencies: 182
-- Data for Name: hobby; Type: TABLE DATA; Schema: public; Owner: resume
--

COPY hobby (id, id_profile, name) FROM stdin;
\.


--
-- TOC entry 2237 (class 0 OID 0)
-- Dependencies: 190
-- Name: hobby_seq; Type: SEQUENCE SET; Schema: public; Owner: resume
--

SELECT pg_catalog.setval('hobby_seq', 1, false);


--
-- TOC entry 2207 (class 0 OID 16723)
-- Dependencies: 181
-- Data for Name: language; Type: TABLE DATA; Schema: public; Owner: resume
--

COPY language (id, id_profile, name, level, type) FROM stdin;
\.


--
-- TOC entry 2238 (class 0 OID 0)
-- Dependencies: 189
-- Name: language_seq; Type: SEQUENCE SET; Schema: public; Owner: resume
--

SELECT pg_catalog.setval('language_seq', 1, false);


--
-- TOC entry 2219 (class 0 OID 16762)
-- Dependencies: 193
-- Data for Name: persistent_logins; Type: TABLE DATA; Schema: public; Owner: resume
--

COPY persistent_logins (username, series, token, last_used) FROM stdin;
\.


--
-- TOC entry 2210 (class 0 OID 16736)
-- Dependencies: 184
-- Data for Name: practic; Type: TABLE DATA; Schema: public; Owner: resume
--

COPY practic (id, id_profile, "position", company, begin_date, finish_date, responsibilities, demo, src) FROM stdin;
\.


--
-- TOC entry 2239 (class 0 OID 0)
-- Dependencies: 188
-- Name: practic_seq; Type: SEQUENCE SET; Schema: public; Owner: resume
--

SELECT pg_catalog.setval('practic_seq', 1, false);


--
-- TOC entry 2223 (class 0 OID 16777)
-- Dependencies: 197
-- Data for Name: profile; Type: TABLE DATA; Schema: public; Owner: resume
--

COPY profile (id, uid, first_name, last_name, birth_day, phone, email, country, city, objective, summary, large_photo, small_photo, info, password, completed, created, skype, vkontakte, facebook, linkedin, github, stackoverflow) FROM stdin;
\.


--
-- TOC entry 2222 (class 0 OID 16774)
-- Dependencies: 196
-- Data for Name: profile_restore; Type: TABLE DATA; Schema: public; Owner: resume
--

COPY profile_restore (id, token) FROM stdin;
\.


--
-- TOC entry 2240 (class 0 OID 0)
-- Dependencies: 186
-- Name: profile_seq; Type: SEQUENCE SET; Schema: public; Owner: resume
--

SELECT pg_catalog.setval('profile_seq', 1, false);


--
-- TOC entry 2211 (class 0 OID 16742)
-- Dependencies: 185
-- Data for Name: skill; Type: TABLE DATA; Schema: public; Owner: resume
--

COPY skill (id, id_profile, category, value) FROM stdin;
\.


--
-- TOC entry 2220 (class 0 OID 16765)
-- Dependencies: 194
-- Data for Name: skill_category; Type: TABLE DATA; Schema: public; Owner: resume
--

COPY skill_category (id, category) FROM stdin;
\.


--
-- TOC entry 2241 (class 0 OID 0)
-- Dependencies: 187
-- Name: skill_seq; Type: SEQUENCE SET; Schema: public; Owner: resume
--

SELECT pg_catalog.setval('skill_seq', 1, false);


--
-- TOC entry 2050 (class 2606 OID 16804)
-- Name: certificate_pkey; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY certificate
    ADD CONSTRAINT certificate_pkey PRIMARY KEY (id);


--
-- TOC entry 2083 (class 2606 OID 16870)
-- Name: course_pkey; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);


--
-- TOC entry 2067 (class 2606 OID 16816)
-- Name: education_pkey; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY education
    ADD CONSTRAINT education_pkey PRIMARY KEY (id);


--
-- TOC entry 2047 (class 2606 OID 16802)
-- Name: hobbi_pkey; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY hobby
    ADD CONSTRAINT hobbi_pkey PRIMARY KEY (id);


--
-- TOC entry 2044 (class 2606 OID 16800)
-- Name: language_pkey; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY language
    ADD CONSTRAINT language_pkey PRIMARY KEY (id);


--
-- TOC entry 2059 (class 2606 OID 16810)
-- Name: persistent_logins_pkey; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY persistent_logins
    ADD CONSTRAINT persistent_logins_pkey PRIMARY KEY (series);


--
-- TOC entry 2054 (class 2606 OID 16806)
-- Name: practic_pkey; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY practic
    ADD CONSTRAINT practic_pkey PRIMARY KEY (id);


--
-- TOC entry 2073 (class 2606 OID 16824)
-- Name: profile_email_key; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY profile
    ADD CONSTRAINT profile_email_key UNIQUE (email);


--
-- TOC entry 2075 (class 2606 OID 16826)
-- Name: profile_phone_key; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY profile
    ADD CONSTRAINT profile_phone_key UNIQUE (phone);


--
-- TOC entry 2077 (class 2606 OID 16822)
-- Name: profile_pkey; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY profile
    ADD CONSTRAINT profile_pkey PRIMARY KEY (id);


--
-- TOC entry 2069 (class 2606 OID 16818)
-- Name: profile_restore_pkey; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY profile_restore
    ADD CONSTRAINT profile_restore_pkey PRIMARY KEY (id);


--
-- TOC entry 2071 (class 2606 OID 16820)
-- Name: profile_restore_uid_key; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY profile_restore
    ADD CONSTRAINT profile_restore_uid_key UNIQUE (token);


--
-- TOC entry 2079 (class 2606 OID 16828)
-- Name: profile_uid_key; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY profile
    ADD CONSTRAINT profile_uid_key UNIQUE (uid);


--
-- TOC entry 2061 (class 2606 OID 16814)
-- Name: skill_category_category_key; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY skill_category
    ADD CONSTRAINT skill_category_category_key UNIQUE (category);


--
-- TOC entry 2063 (class 2606 OID 16812)
-- Name: skill_category_pkey; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY skill_category
    ADD CONSTRAINT skill_category_pkey PRIMARY KEY (id);


--
-- TOC entry 2057 (class 2606 OID 16808)
-- Name: skill_pkey; Type: CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (id);


--
-- TOC entry 2048 (class 1259 OID 16789)
-- Name: certificate_idx; Type: INDEX; Schema: public; Owner: resume
--

CREATE INDEX certificate_idx ON certificate USING btree (id_profile);


--
-- TOC entry 2080 (class 1259 OID 16797)
-- Name: course_idx; Type: INDEX; Schema: public; Owner: resume
--

CREATE INDEX course_idx ON course USING btree (finish_date);


--
-- TOC entry 2081 (class 1259 OID 16798)
-- Name: course_idx1; Type: INDEX; Schema: public; Owner: resume
--

CREATE INDEX course_idx1 ON course USING btree (id_profile);


--
-- TOC entry 2064 (class 1259 OID 16795)
-- Name: education_idx; Type: INDEX; Schema: public; Owner: resume
--

CREATE INDEX education_idx ON education USING btree (id_profile);


--
-- TOC entry 2065 (class 1259 OID 16796)
-- Name: education_idx1; Type: INDEX; Schema: public; Owner: resume
--

CREATE INDEX education_idx1 ON education USING btree (finish_year);


--
-- TOC entry 2045 (class 1259 OID 16790)
-- Name: hobbi_idx; Type: INDEX; Schema: public; Owner: resume
--

CREATE INDEX hobbi_idx ON hobby USING btree (id_profile);


--
-- TOC entry 2042 (class 1259 OID 16791)
-- Name: language_idx; Type: INDEX; Schema: public; Owner: resume
--

CREATE INDEX language_idx ON language USING btree (id_profile);


--
-- TOC entry 2051 (class 1259 OID 16792)
-- Name: practic_idx; Type: INDEX; Schema: public; Owner: resume
--

CREATE INDEX practic_idx ON practic USING btree (id_profile);


--
-- TOC entry 2052 (class 1259 OID 16794)
-- Name: practic_idx1; Type: INDEX; Schema: public; Owner: resume
--

CREATE INDEX practic_idx1 ON practic USING btree (finish_date);


--
-- TOC entry 2055 (class 1259 OID 16793)
-- Name: skill_idx; Type: INDEX; Schema: public; Owner: resume
--

CREATE INDEX skill_idx ON skill USING btree (id_profile);


--
-- TOC entry 2086 (class 2606 OID 16829)
-- Name: certificate_fk; Type: FK CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY certificate
    ADD CONSTRAINT certificate_fk FOREIGN KEY (id_profile) REFERENCES profile(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2092 (class 2606 OID 16871)
-- Name: course_fk; Type: FK CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY course
    ADD CONSTRAINT course_fk FOREIGN KEY (id_profile) REFERENCES profile(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2090 (class 2606 OID 16834)
-- Name: education_fk; Type: FK CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY education
    ADD CONSTRAINT education_fk FOREIGN KEY (id_profile) REFERENCES profile(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2085 (class 2606 OID 16839)
-- Name: hobby_fk; Type: FK CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY hobby
    ADD CONSTRAINT hobby_fk FOREIGN KEY (id_profile) REFERENCES profile(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2084 (class 2606 OID 16844)
-- Name: language_fk; Type: FK CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY language
    ADD CONSTRAINT language_fk FOREIGN KEY (id_profile) REFERENCES profile(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2089 (class 2606 OID 16849)
-- Name: persistent_logins_fk; Type: FK CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY persistent_logins
    ADD CONSTRAINT persistent_logins_fk FOREIGN KEY (username) REFERENCES profile(uid) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2087 (class 2606 OID 16854)
-- Name: practic_fk; Type: FK CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY practic
    ADD CONSTRAINT practic_fk FOREIGN KEY (id_profile) REFERENCES profile(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2091 (class 2606 OID 16859)
-- Name: profile_restore_fk; Type: FK CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY profile_restore
    ADD CONSTRAINT profile_restore_fk FOREIGN KEY (id) REFERENCES profile(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2088 (class 2606 OID 16864)
-- Name: skill_fk; Type: FK CONSTRAINT; Schema: public; Owner: resume
--

ALTER TABLE ONLY skill
    ADD CONSTRAINT skill_fk FOREIGN KEY (id_profile) REFERENCES profile(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 2232 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-04-25 13:42:25

--
-- PostgreSQL database dump complete
--

