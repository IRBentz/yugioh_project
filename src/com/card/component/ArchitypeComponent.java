package com.card.component;

import static com.card.component.CardComponent.Architype;
import static com.card.component.HexCode.*;

public enum ArchitypeComponent implements CardSubcomponentInterface {
	AllyOfJustice(Hex_1), Genex(Hex_2), RGenex(Hex_100_2), GenexAlly(Hex_200_2), Horus(Hex_3),
	HorusBlackFlameDragon(Hex_100_3), Amazoness(Hex_4), ArcanaForce(Hex_5), DarkWorld(Hex_6), AncientGear(Hex_7),
	Hero(Hex_8), ElementalHero(Hex_300_8), VisionHero(Hex_500_8), EvilHero(Hex_600_8), MaskedHero(Hex_A00_8),
	DestinyHero(Hex_C00_8), Neos(Hex_9), Lswarm(Hex_A), Steelswarm(Hex_100_A), Infernity(Hex_B), Alien(Hex_C),
	Saber(Hex_D), XSaber(Hex_100_D), XxSaber(Hex_300_D), Elementsaber(Hex_400_D), Watt(Hex_E), Ojama(Hex_F),
	Gusto(Hex_10), Karakuri(Hex_11), Frog(Hex_12), Meklord(Hex_13), MeklordEmperor(Hex_30_13), MeklordArmy(Hex_60_13),
	MeklordAstro(Hex_90_13), AllureQueen(Hex_14), Bes(Hex_15), Roid(Hex_16), Vehicroid(Hex_10_16), Speedroid(Hex_20_16),
	Synchro(Hex_17), Synchron(Hex_10_17), SynchroDragon(Hex_20_17), Cloudian(Hex_18), Gladiator(Hex_19),
	GladiatorBeast(Hex_10_19), DarkScorpion(Hex_1A), PhantomBeast(Hex_1B), MechaPhantomBeast(Hex_10_1B),
	SpiritMessage(Hex_1C), KoakiMeiru(Hex_1D), Chrysalis(Hex_1E), NeoSpacian(Hex_1F), Shien(Hex_20), Earthbound(Hex_21),
	EarthboundImmortal(Hex_10_21), Jurrac(Hex_22), Malefic(Hex_23), Scrap(Hex_24), IronChain(Hex_25),
	Morphtronic(Hex_26), Tg(Hex_27), Batteryman(Hex_28), Dragunity(Hex_29), Naturia(Hex_2A), Ninja(Hex_2B),
	Flamvell(Hex_2C), Nitro(Hex_2D), Gravekeepers(Hex_2E), IceBarrier(Hex_2F), Vylon(Hex_30), FortuneLady(Hex_31),
	Volcanic(Hex_32), Blackwing(Hex_33), AssaultBlackwing(Hex_10_33), Crystal(Hex_34), CrystalBeast(Hex_10_34),
	UltimateCrystal(Hex_20_34), AdvancedCrystalBeast(Hex_50_34), Fabled(Hex_35), Machina(Hex_36), MistValley(Hex_37),
	Lightsworn(Hex_38), Laval(Hex_39), Gishki(Hex_3A), RedEyes(Hex_3B), Reptilianne(Hex_3C), SixSamurai(Hex_3D),
	SecretSixSamurai(Hex_10_3D), Worm(Hex_3E), Majestic(Hex_3F), ForbiddenOne(Hex_40), Lv(Hex_41), Nordic(Hex_42),
	NordicAscendant(Hex_30_42), NordicBeast(Hex_60_42), NordicAlfar(Hex_A0_42), NordicRelic(Hex_50_42), Junk(Hex_43),
	TheAgent(Hex_44), Archfiend(Hex_45), RedDragonArchfiend(Hex_10_45), Fusion(Hex_46), FusionDragon(Hex_10_46),
	Gem(Hex_47), GemKnight(Hex_10_47), Number(Hex_48), NumberC(Hex_10_48), NumberC39(Hex_50_48), Skyblaster(Hex_49),
	Timelord(Hex_4A), Aesir(Hex_4B), TrapHole(Hex_4C), BeastsBattle(Hex_4D), Evoltile(Hex_30_4E), Evolsaur(Hex_60_4E),
	Evolzar(Hex_50_4E), DarkLucius(Hex_4F), AssaultMode(Hex_10_4F), Venom(Hex_50), StarvingVenom(Hex_10_50),
	Gadget(Hex_51), Guardian(Hex_52), GateGuardian(Hex_10_52), SkullGuardian(Hex_20_52), Constellar(Hex_53),
	Gagaga(Hex_54), Photon(Hex_55), Inzektor(Hex_56), Resonator(Hex_57), WindUp(Hex_58), Gogogo(Hex_59),
	Penguin(Hex_5A), Inmato(Hex_5B), Sphinx(Hex_5C), UltimateInsect(Hex_5D), DarkMimic(Hex_5E), MysticSwordsman(Hex_5F),
	BambooSword(Hex_60), NinjitsuArt(Hex_61), Toon(Hex_62), Reactor(Hex_63), Harpie(Hex_64), Infestation(Hex_65),
	Warrior(Hex_66), SymphonicWarrior(Hex_10_66), MagnetWarrior(Hex_20_66), Hieratic(Hex_69), Butterspy(Hex_6A),
	Bounzer(Hex_6B), Helios(Hex_6C), Djinn(Hex_6D), Prophecy(Hex_6E), Spellbook(Hex_10_6E), Heroic(Hex_6F),
	HeroicChallenger(Hex_10_6F), HeroicChampion(Hex_20_6F), Chronomaly(Hex_70), Madolche(Hex_71), Geargia(Hex_72),
	Geargiano(Hex_10_72), Xyz(Hex_73), Cxyz(Hex_10_73), XyzDragon(Hex_20_73), ArmoredXyz(Hex_40_73), Mermail(Hex_74),
	Abyss(Hex_75), HeraldicBeast(Hex_76), Atlantean(Hex_77), Nimble(Hex_78), FireFist(Hex_79), NobleKnight(Hex_10_7A),
	InfernobleKnight(Hex_50_7A), NobleArms(Hex_20_7A), InfernobleArms(Hex_60_7A), Galaxy(Hex_7B), GalaxyEyes(Hex_10_7B),
	GalaxyEyesTachyonDragon(Hex_30_7B), FireFormation(Hex_7C), Hazy(Hex_7D), HazyFlame(Hex_10_7D), Zexal(Hex_7E),
	Zw(Hex_10_7E), Zs(Hex_20_7E), Utopic(Hex_7F), Utopia(Hex_10_7F), UtopicFuture(Hex_20_7F), Duston(Hex_80),
	FireKing(Hex_81), FireKingAvatar(Hex_10_81), Dododo(Hex_82), Puppet(Hex_83), GimmickPuppet(Hex_10_83),
	BattlinBoxer(Hex_84), SuperDefenseRobot(Hex_85), StarSeraph(Hex_86), UmbralHorror(Hex_87), Bujin(Hex_88),
	Hole(Hex_89), Traptrix(Hex_10_8A), Malicevorous(Hex_8B), Ghostrick(Hex_8D), Vampire(Hex_8E), Zubaba(Hex_8F),
	Sylvan(Hex_90), Necrovalley(Hex_91), Heraldry(Hex_92), Cyber(Hex_93), CyberDragon(Hex_10_93), CyberAngel(Hex_20_93),
	Cyberdark(Hex_40_93), Cybernetic(Hex_94), RankUpMagic(Hex_95), Fishborg(Hex_96), Artifact(Hex_97), Magician(Hex_98),
	OddEyes(Hex_99), SuperheavySamurai(Hex_9A), SuperheavySamuraiSoul(Hex_1_09A), Melodious(Hex_9B),
	MelodiousMaestra(Hex_10_9B), Tellarknight(Hex_9C), Stellarknight(Hex_10_9C), Shaddoll(Hex_9D), YangZing(Hex_9E),
	Performapal(Hex_9F), LegendaryKnight(Hex_A0), LegendaryDragon(Hex_A1), DarkMagician(Hex_10_A2),
	MagicianGirl(Hex_20_A2), DarkMagicianGirl(Hex_30_A2), Stardust(Hex_A3), Kuriboh(Hex_A4), WingedKuriboh(Hex_10_A4),
	Change(Hex_A5), Sprout(Hex_A6), Artorigus(Hex_A7), Laundsallyn(Hex_A8), Fluffal(Hex_A9), Qli(Hex_Aa),
	Apoqliphort(Hex_10_Aa), Deskbot(Hex_Ab), Goblin(Hex_Ac), GoblinRider(Hex_10_Ac), Frightfur(Hex_Ad),
	DarkContract(Hex_Ae), Dd(Hex_Af), Ddd(Hex_10_Af), Gottoms(Hex_B0), BurningAbyss(Hex_B1), Ua(Hex_B2),
	Yosenju(Hex_B3), Nekroz(Hex_B4), RitualBeast(Hex_B5), RitualBeastTamer(Hex_10_B5), SpiritualBeast(Hex_20_B5),
	SpiritualBeastTamer(Hex_30_B5), RitualBeastUlti(Hex_40_B5), OuterEntity(Hex_10_B7), ElderEntity(Hex_20_B7),
	OldEntity(Hex_40_B7), BlazeAccelerator(Hex_B9), Raidraptor(Hex_Ba), Infernoid(Hex_Bb), Jinzo(Hex_Bc),
	GaiaTheFierceKnight(Hex_Bd), Monarch(Hex_Be), Charmer(Hex_Bf), Possessed(Hex_C0), FamiliarPossessed(Hex_10_C0),
	PsyFrame(Hex_C1), PsyFramegear(Hex_10_C1), PowerTool(Hex_C2), EdgeImp(Hex_C3), Zefra(Hex_C4), Void(Hex_C5),
	Performage(Hex_C6), Dracoslayer(Hex_C7), Igknight(Hex_C8), Aroma(Hex_C9), EmpoweredWarrior(Hex_Ca), Aether(Hex_Cb),
	PredictionPrincess(Hex_Cc), Aquaactress(Hex_10_Cd), Aquarium(Hex_20_Cd), Chaos(Hex_Cf),
	BlackLusterSoldier(Hex_10_Cf), Majespecter(Hex_D0), Graydle(Hex_D1), Kozmo(Hex_D2), Kaiju(Hex_D3),
	Paleozoic(Hex_D4), Dante(Hex_D5), DestructionSword(Hex_D6), BusterBlader(Hex_D7), Dinomist(Hex_D8),
	Shiranui(Hex_D9), ShiranuiSpectralsword(Hex_10_D9), Dracoverlord(Hex_Da), PhantomKnights(Hex_Db),
	ThePhantomKnights(Hex_10_Db), SuperQuant(Hex_Dc), SuperQuantum(Hex_10_Dc), SuperQuantalMechBeast(Hex_20_Dc),
	BlueEyes(Hex_Dd), Exodia(Hex_De), Lunalight(Hex_Df), Amorphage(Hex_E0), Metalfoes(Hex_E1), Triamid(Hex_E2),
	Cubic(Hex_E3), CelticGuard(Hex_E4), Cipher(Hex_E5), CipherDragon(Hex_10_E5), FlowerCardian(Hex_E6),
	SilentSwordsman(Hex_E7), SilentMagician(Hex_E8), MagnaWarrior(Hex_E9), Crystron(Hex_Ea), Chemicritter(Hex_Eb),
	AbyssActor(Hex_10_Ec), AbyssScript(Hex_20_Ec), Subterror(Hex_Ed), SubterrorBehemoth(Hex_10_Ed), Spyral(Hex_Ee),
	SpyralGear(Hex_10_Ee), SpyralMission(Hex_20_Ee), Darklord(Hex_Ef), Windwitch(Hex_F0), Zoodiac(Hex_F1),
	Pendulum(Hex_F2), PendulumDragon(Hex_10_F2), Pendulumgraph(Hex_20_F2), Predap(Hex_F3), Predaplant(Hex_10_F3),
	Invoked(Hex_F4), Gandora(Hex_F5), Skyscraper(Hex_F6), Lyrilusc(Hex_F7), SupremeKingGate(Hex_10_F8),
	SupremeKingDragon(Hex_20_F8), TrueDracoKing(Hex_F9), PhantasmSpiral(Hex_Fa), Trickstar(Hex_Fb), Gouki(Hex_Fc),
	WorldChalice(Hex_Fd), WorldLegacy(Hex_Fe), ClearWing(Hex_Ff), Bonding(Hex_100), CodeTalker(Hex_101),
	Rokket(Hex_102), Altergeist(Hex_103), Krawler(Hex_104), Metaphys(Hex_105), Vendread(Hex_106), Fa(Hex_107),
	MagicalMusket(Hex_108), TheWeather(Hex_109), Parshath(Hex_10A), Tindangle(Hex_10B), MekkKnight(Hex_10C),
	MythicalBeast(Hex_10D), EvolutionPill(Hex_10E), Borrel(Hex_10F), Relinquished(Hex_110), EyesRestrict(Hex_1_110),
	ArmedDragon(Hex_111), ArmedDragonThunder(Hex_1_111), Knightmare(Hex_112), ElementalLord(Hex_113), FurHire(Hex_114),
	SkyStriker(Hex_115), SkyStrikerAce(Hex_1_115), Crusadia(Hex_116), Impcantation(Hex_117), Cynet(Hex_118),
	Salamangreat(Hex_119), Dinowrestler(Hex_11A), Orcust(Hex_11B), ThunderDragon(Hex_11C), Forbidden(Hex_11D),
	Danger(Hex_11E), Nephthys(Hex_11F), PrankKids(Hex_120), Mayakashi(Hex_121), Valkyrie(Hex_122), Rose(Hex_123),
	RoseDragon(Hex_1_123), MachineAngel(Hex_124), Smile(Hex_125), TimeThief(Hex_126), Infinitrack(Hex_127),
	Witchcrafter(Hex_128), EvilEye(Hex_129), Endymion(Hex_12A), Marincess(Hex_12B), Tenyi(Hex_12C), Simorgh(Hex_12D),
	FortuneFairy(Hex_12E), Battlewasp(Hex_12F), Unchained(Hex_130), UnchainedSoul(Hex_1_130), DreamMirror(Hex_131),
	Mathmech(Hex_132), Dragonmaid(Hex_133), Generaider(Hex_134), Ignister(Hex_135), Ai(Hex_136),
	AncientWarriors(Hex_137), Megalith(Hex_138), Onomat(Hex_139), Palladium(Hex_13A), Rebellion(Hex_13B),
	Codebreaker(Hex_13C), Nemeses(Hex_13D), Barbaros(Hex_13E), PlunderPatroll(Hex_13F), Adamancipator(Hex_140),
	Rikka(Hex_141), Eldlich(Hex_142), Eldlixir(Hex_143), GoldenLand(Hex_144), Phantasm(Hex_145), Dogmatika(Hex_146),
	Melffy(Hex_147), Potan(Hex_148), Roland(Hex_149), Appliancer(Hex_14A), Numeron(Hex_14B), NumeronGate(Hex_1_14B),
	Fossil(Hex_14C), SpiritualEarthArt(Hex_3_14D), SpiritualFireArt(Hex_5_14D), SpiritualWaterArt(Hex_6_14D),
	SpiritualWindArt(Hex_A_14D), DualAvatar(Hex_14E), TriBrigade(Hex_14F), VirtualWorld(Hex_150),
	VirtualWorldGate(Hex_1_150), Drytron(Hex_151), Magistus(Hex_152), KiSikil(Hex_153), LilLa(Hex_154),
	EvilTwin(Hex_155), LiveTwin(Hex_156), Sunavalon(Hex_1_157), Sunvine(Hex_2_157), Sunseed(Hex_4_157),
	Springans(Hex_158), Myutant(Hex_159), SForce(Hex_15A), StarryKnight(Hex_15B), DollMonster(Hex_15C),
	RankDownMagic(Hex_15D), Amazement(Hex_15E), Attraction(Hex_15F), Branded(Hex_160), WarRock(Hex_161),
	Materiactor(Hex_162), Ogdoadic(Hex_163), Solfachord(Hex_164), Gransolfachord(Hex_1_164), Ursarctic(Hex_165),
	Despia(Hex_166), Magikey(Hex_167), Gunkan(Hex_168), MysticalBeastOfTheForest(Hex_1_169),
	MysticalSpiritOfTheForest(Hex_2_169), StealthKragen(Hex_16A), Numerounious(Hex_16B), NumberSpellTrap(Hex_16C),
	Swordsoul(Hex_16D), Icejade(Hex_16E), Floowandereeze(Hex_16F), Topologic(Hex_170), Hyperion(Hex_171),
	Beetrooper(Hex_172), Punk(Hex_173), Exosister(Hex_174), Dinomorphia(Hex_175), LadyOfLament(Hex_176),
	Seventh(Hex_177), Barians(Hex_1_178), Battleguard(Hex_2_178), KairyuShin(Hex_179), SeaStealth(Hex_17A),
	Therion(Hex_17B), Scareclaw(Hex_17C), Libromancer(Hex_17D), Vaylantz(Hex_17E), Labrynth(Hex_17F),
	WelcomeLabrynth(Hex_1_17F), Runick(Hex_180), Spright(Hex_181), Tearlaments(Hex_182), Vernusylph(Hex_183),
	MokeyMokey(Hex_184), Wingman(Hex_185), DoodleBeast(Hex_1_186), Doodlebook(Hex_2_186), GGolem(Hex_187),
	RainbowBridge(Hex_188), Bystial(Hex_189), Ghoti(Hex_18B), Kashtira(Hex_18A), GoldPride(Hex_193), Koala(Hex_67),
	Kangaroo(Hex_68), RescueAce(Hex_18C), Purrely(Hex_18D), Mikanko(Hex_18E), Aquamirror(Hex_18F), Firewall(Hex_190),
	Mannadium(Hex_191), Nemleria(Hex_192), LabyrinthWall(Hex_194), Favorite(Hex_195), VanquishSoul(Hex_196),
	Nouvelles(Hex_197), Recipe(Hex_198), Visas(Hex_199), Memento(Hex_19A), Centurion(Hex_19B), Vaalmonica(Hex_19C),
	Yubel(Hex_19D), VoicelessVoice(Hex_19E), Toy(Hex_1A0), TenpaiDragon(Hex_1A1), Sangen(Hex_1A2), Ragnaraika(Hex_1A3),
	Millennium(Hex_1A6), Exodd(Hex_1A7), Fiendsmith(Hex_1A8), WhiteForest(Hex_1Aa), Mulcharmy(Hex_1Ac),
	Emblema(Hex_1Ad), Counter(Hex_200), BattlinBoxing(Hex_201), Veda(Hex_202), Diabell(Hex_203),
	Diabellestar(Hex_1_203), SinfulSpoils(Hex_204), SnakeEye(Hex_205), Patissciel(Hex_206), Heart(Hex_207),
	Tistina(Hex_208), WhiteAura(Hex_1_19F), Salamandra(Hex_1A4), Ashened(Hex_1A5), BlueTears(Hex_1A9), Tachyon(Hex_1Ab),
	Shark(Hex_1Ae), SharkDrake(Hex_1_1Ae), Wedju(Hex_1Af), Primite(Hex_1B0), SixStrike(Hex_1B1), Metalmorph(Hex_1B2),
	Morganite(Hex_1B3), Azamina(Hex_1B4), Mimighoul(Hex_1B5), Ryzeal(Hex_1B6), Schoolwork(Hex_1B7), RyuGe(Hex_1B8),
	Maliss(Hex_1B9), Argostars(Hex_1Ba), AquaJet(Hex_1Bb), DragonRuler(Hex_1Bc), Mitsurugi(Hex_1Bd), Dominus(Hex_1Bf),
	Apophis(Hex_1C2), Serket(Hex_1C3),;

	private final CardComponent cardComponent = Architype;
	private final HexCode hexCode;

	private ArchitypeComponent(HexCode hexCode) {
		this.hexCode = hexCode;
	}

	@Override
	public String getComponentName() {
		return cardComponent.getComponentName();
	}

	public HexCode getHexCode() {
		return this.hexCode;
	}
	
	@Override
	public String getName() {
		return this.name();
	}

	@Override
	public ArchitypeComponent match(String name) {
		for (ArchitypeComponent architypeComponent : ArchitypeComponent.class.getEnumConstants())
			if (architypeComponent.name().equals(name))
				return architypeComponent;
		return null;
	}
}
